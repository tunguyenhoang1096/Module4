package com.ra.controller;

import com.ra.exception.StudentNotFoundException;
import com.ra.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    // giả xử có danh sách sinh viên cố định
    private List<Student> students =  new ArrayList<>();
    public StudentController() {
        students.add(new Student("SV01","Nguyễn Hoàng Tú"));
        students.add(new Student("SV02","Trần Thị Quỳnh"));
        students.add(new Student("SV03","Hoàng Quốc Việt"));
    }

    // api tìm sv theo id
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id){
        for(Student student : students){
            if(student.getStudentId().equals(id)){
                return student;
            }
        }
        throw new StudentNotFoundException("Không tìm thấy sinh viên có mã "+id);
    }

}
