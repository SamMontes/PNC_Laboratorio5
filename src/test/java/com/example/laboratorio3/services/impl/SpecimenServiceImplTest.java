package com.example.laboratorio3.services.impl;

import com.example.laboratorio3.common.SpecimenMapper;
import com.example.laboratorio3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio3.domain.dto.response.specimen.SpecimenResponse;
import com.example.laboratorio3.domain.entities.Specimen;
import com.example.laboratorio3.exceptions.ResourceNotFoundException;
import com.example.laboratorio3.repositories.SpecimenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpecimenServiceImplTest {

    @Mock
    private SpecimenRepository specimenRepository;
    @Mock
    private SpecimenMapper specimenMapper;

    @InjectMocks
    private SpecimenServiceImpl specimenService;

    @Test
    void createSpecimen_ShouldReturnResponse_WhenSuccessful() {
        CreateSpecimenRequest request = new CreateSpecimenRequest();
        Specimen createEntity = new Specimen();
        Specimen savedEntity = new Specimen();
        SpecimenResponse response = new SpecimenResponse();

        when(specimenMapper.toEntityCreate(request)).thenReturn(createEntity);
        when(specimenRepository.save(any())).thenReturn(savedEntity);
        when(specimenMapper.toDto(any())).thenReturn(response);

        SpecimenResponse result = specimenService.createSpecimen(request);

        assertNotNull(result);
        assertEquals(response, result);
        verify(specimenRepository, times(1)).save(any());
    }

    @Test
    void getSpecimenById_ShouldThrowException_WhenIdNotFound() {
        UUID id = UUID.randomUUID();
        when(specimenRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            specimenService.getSpecimenById(id);
        });

        verify(specimenRepository).findById(id);
    }

    @Test
    void deleteSpecimen_ShouldReturnDeletedSpecimen_WhenSuccessful() {

        UUID id = UUID.randomUUID();
        Specimen entityFound = new Specimen();
        SpecimenResponse response = new SpecimenResponse();

        when(specimenRepository.findById(id)).thenReturn(Optional.of(entityFound));
        when(specimenMapper.toDto(any())).thenReturn(response);

        SpecimenResponse result= specimenService.deleteSpecimen(id);

        assertNotNull(result);
        verify(specimenRepository, times(1)).deleteById(id);
    }
}
