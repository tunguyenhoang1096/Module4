package com.ra.service;

import com.ra.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> findAll();
    Doctor findById(Long id);
    Doctor addDoctor(Doctor doctor);
    Doctor update(Doctor doctor,Long id);
    void deleteDoctor(Long id);
}
