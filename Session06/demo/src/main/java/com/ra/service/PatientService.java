package com.ra.service;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import com.ra.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {
    PaginationResponse<Patient> findAllAndSearch(Pageable pageable, String name);

}
