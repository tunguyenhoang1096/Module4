package com.ra.controller;

import com.ra.model.Patient;
import com.ra.model.dto.PaginationResponse;
import com.ra.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @GetMapping("/search")
    public ResponseEntity<?> searchPatient(
            @PageableDefault(
                    size = 3,
                    sort = "patientCode",
                    direction = Sort.Direction.DESC
            )Pageable pageable, @RequestParam(required = false,defaultValue = "",name = "keyword")  String keyword) {
            PaginationResponse<Patient> response = patientService.findAllAndSearch(pageable, keyword);
            return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
