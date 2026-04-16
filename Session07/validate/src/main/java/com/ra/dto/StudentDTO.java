package com.ra.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {
    // Validation dữ liệu văn bản (Họ tên & Chuyên ngành)
    @NotBlank(message = "Họ tên k được để trống")
    @Size(min = 5,max = 100,message = "Độ dài từ 5-100 ký tự")
    private String fullName;

    @NotBlank(message = "Chuyên ngành k được để trống")
    private String major;

    // Validation số học (Điểm số & Tuổi)
    @Min(value = 18,message = "Tuổi phải từ 18 trở lên")
    private Integer age;

    @Min(value = 0,message = "Điểm phải nằm trong khoảng 0-10")
    @Max(value = 10,message = "Điểm phải nằm trong khoảng từ 0-10")
    private Double gpa;

    //Validation định dạng Mã Sinh viên (Regex)
    @Pattern(regexp = "^SV\\d{4}$",message = "Mã sinh viên có định dang SVxxxx (VD: SV1234)")
    private String studentCode;
}
