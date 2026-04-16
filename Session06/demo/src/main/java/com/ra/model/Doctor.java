package com.ra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dortor_code")
    private String dortorCode;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "experience_years")
    private int experienceYears;

}
