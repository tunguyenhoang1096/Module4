package com.example.repository;

import com.example.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepository {
    private List<Employee> employees = new ArrayList<>();

    // Khởi tạo đối tượng mẫu
    public EmployeeRepository() {
        employees.add(new Employee(1,"Nguyễn Văn Tuấn","nguyentuan@gmail.com","CEO"));
        employees.add(new Employee(2,"Hoàng Ngọc Linh","hoanglinh@gmail.com","IT"));
        employees.add(new Employee(3,"Đỗ Thị Lan","lando@gmail.com","HR"));
    }

    public List<Employee> findAll() {
        return employees;
    }

    public Optional<Employee> findById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    public void save(Employee employee) {
        employees.add(employee);
    }

    public void update(int id, Employee newEmployee){
        findById(id).ifPresent(employee -> {
            employee.setFullName(newEmployee.getFullName());
            employee.setEmail((newEmployee.getEmail()));
            employee.setDepartment(newEmployee.getDepartment());
        });
    }

    public boolean delete(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }


}
