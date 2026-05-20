package com.example.laboratorio3.services.impl;

import com.example.laboratorio3.common.SpecimenMapper;
import com.example.laboratorio3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio3.domain.dto.responses.SpecimenResponse;
import com.example.laboratorio3.repositories.SpecimenRepository;
import com.example.laboratorio3.services.SpecimenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecimenServiceImpl implements SpecimenService {
    private final SpecimenRepository specimenRepository;
    private final SpecimenMapper specimenMapper;

}
