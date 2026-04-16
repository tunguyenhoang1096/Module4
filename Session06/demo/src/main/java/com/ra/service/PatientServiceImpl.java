package com.ra.service;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import com.ra.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PaginationResponse<Patient> findAllAndSearch(Pageable pageable, String name) {
        Page<Patient> patientPage = patientRepository.findByFullNameContainingIgnoreCase(name, pageable);
        // Convert Entity => DTO

        return PaginationResponse.<Patient>builder()
                .data(patientPage.getContent())
                .totalPage(patientPage.getTotalPages())
                .totalElement((int) patientPage.getTotalElements())
                .currentPage(patientPage.getNumber())
                .build();
    }
}
