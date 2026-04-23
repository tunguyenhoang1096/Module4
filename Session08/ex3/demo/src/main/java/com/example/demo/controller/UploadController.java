package com.example.demo.controller;

import com.example.demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
//    @PostMapping("/api/uploads")
//    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
//        if (file == null || file.isEmpty() || file.getSize() == 0 ) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File k hợp lệ");
//        }else {
//            String path = uploadService.upload(file);
//            return ResponseEntity.status(HttpStatus.OK).body("Upload successfully\n"+ path);
//        }
//    }

    // Bài 4
    @PostMapping("/api/uploads")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        String fileName = uploadService.upload(file);
        return ResponseEntity.ok("Upload thành công" + fileName);
    }
}
