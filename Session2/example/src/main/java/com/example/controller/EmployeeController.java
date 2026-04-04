package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees") // Định nghĩa tiền tố chung cho tất cả phương thức
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService; // tiêm service vào controller

    // API lấy danh sách nhân viên
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // API lấy chi tiết nhân viên
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

    // API tìm nhân viên theo tên
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployee(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByName(name));
    }

    // API thêm mới nhân viên
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmp = employeeService.createEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmp);
    }

    //API cập nhật nhân viên
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee updatedEmp = employeeService.updateEmployee(id, employee);
        if (updatedEmp != null) {
            return ResponseEntity.ok(updatedEmp);
        }else  {
            return ResponseEntity.notFound().build();
        }
    }

    //API xóa nhân viên
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        }
        else  {
            return ResponseEntity.notFound().build();
        }
    }

}
