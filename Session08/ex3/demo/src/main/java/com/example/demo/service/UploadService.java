package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadService {
    private static final String UPLOAD_URL = "C:\\Users\\ADMIN\\OneDrive\\Desktop\\Rikkei\\Modun IV Web Service\\Session08\\ex3\\demo\\uploads";
//    public String upload(MultipartFile file) {
//        try {
//            String uuidFileName = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
//            Path path = Paths.get(UPLOAD_URL+"/"+uuidFileName);
//            Files.createDirectories(path.getParent());
//            file.transferTo(path.toFile());
//            return path.toString();
//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }

    // Bài 4
    public String upload(MultipartFile file) {
        if(file == null || file.isEmpty()) {
            throw new RuntimeException("File không được trống");
        }
        String fileName = file.getOriginalFilename();
        if(fileName == null || !fileName.endsWith(".png") ||  !fileName.endsWith(".jpg")) {
            throw new RuntimeException("Chỉ chấp nhận file có đuôi .png hoặc .jpg");
        }
        String contentType = file.getContentType();
        if(contentType == null || !(contentType.equals("image/png") || contentType.equals("image/jpg"))) {
            throw new RuntimeException("File k hợp lệ");
        }
        try {
            String uuidFileName = UUID.randomUUID().toString()+"_"+fileName;
            Path path = Paths.get(UPLOAD_URL+"/"+uuidFileName);
            Files.createDirectories(path.getParent());
            file.transferTo(path.toFile());
            return path.toString();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
