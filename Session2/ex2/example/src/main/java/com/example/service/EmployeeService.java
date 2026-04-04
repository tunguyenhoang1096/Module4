package com.example.service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository; // tiêm repository vào service

    // nghiệp vụ lấy toàn bộ danh sách nhân viene
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // nghiệp vụ lấy nhân viên theo id
    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // nghiệp vụ thêm mới nhân viên
    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    // nghiệp vụ update nhân viên
    public Employee updateEmployee(int id, Employee employee) {
        if(employeeRepository.findById(id).isPresent()) {
            employeeRepository.update(id, employee);
            return employee;
        }
        return null;
    }

    //nghiệp vụ xóa nhân viên
    public boolean deleteEmployee(int id) {
        return employeeRepository.delete(id);
    }
}
