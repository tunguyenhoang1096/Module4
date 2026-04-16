package com.ra.repository;

import com.ra.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByFullNameContainingIgnoreCase(String fullName, Pageable pageable);

}
