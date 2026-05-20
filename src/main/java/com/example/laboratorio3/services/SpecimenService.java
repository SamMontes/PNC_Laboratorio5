package com.example.laboratorio3.services;

import com.example.laboratorio3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio3.domain.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio3.domain.dto.response.specimen.SpecimenResponse;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    public SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    public List<SpecimenResponse> getAllSpecimens();

    public SpecimenResponse getSpecimenById(UUID id);

    public SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    public SpecimenResponse deleteSpecimen(UUID id);
}
