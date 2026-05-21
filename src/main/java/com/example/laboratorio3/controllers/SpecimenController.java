package com.example.laboratorio3.controllers;

import com.example.laboratorio3.domain.dto.request.CreateSpecimenRequest;
import com.example.laboratorio3.domain.dto.request.UpdateSpecimenRequest;
import com.example.laboratorio3.domain.dto.response.GeneralResponse;
import com.example.laboratorio3.services.SpecimenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("api/specimen")
@AllArgsConstructor
public class SpecimenController {
    private final SpecimenService specimenService;

    @PostMapping
    public ResponseEntity<GeneralResponse> createSpecimen(@RequestBody CreateSpecimenRequest specimen){
        return buildResponse(
                "Specimen created succesfully",
                HttpStatus.CREATED,
                specimenService.createSpecimen(specimen)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        return buildResponse(
                "Products found",
                HttpStatus.OK,
                specimenService.getAllSpecimens(page, size, sortBy, sortOrder)
        );
    }

    @GetMapping("getBy/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(@PathVariable UUID id){
        return buildResponse(
                "Specimen found",
                HttpStatus.OK,
                specimenService.getSpecimenById(id)
        );
    }

    @PutMapping("update/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(@PathVariable UUID id, @RequestBody UpdateSpecimenRequest request){
        return buildResponse(
                "Specimen updated succesfully",
                HttpStatus.OK,
                specimenService.updateSpecimen(id, request)
        );
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecimen(@PathVariable UUID id){
        return buildResponse(
                "Specimen deleted succesfully",
                HttpStatus.OK,
                specimenService.deleteSpecimen(id)
        );
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }
}
