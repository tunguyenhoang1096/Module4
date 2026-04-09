package com.ra.controller;

import com.ra.model.Author;
import com.ra.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorServiceImpl authorService;
    @GetMapping("/api/v1/authors") // ex1: hiện thị dữ liệu danh sách tác giả
    public ResponseEntity<?> getAuthors() {
        List<Author> authors = authorService.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    //ex2 thêm mới tác giả
    @PostMapping("/api/v1/authors")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        Author newAuthor = authorService.create(author);
        return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
    }

    //ex3 tìm tác giả theo id
    @GetMapping("/api/v1/authors/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable int id) {
        Author author = authorService.findById(id);
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
    //ex4 cập nhật tác giả
    @PutMapping("/api/v1/authors/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody Author author) {
        Author updatedAuthor = authorService.update(author,id);
        if (updatedAuthor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    //ex5: xóa tác giả theo id
    @DeleteMapping("/api/v1/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id) {
        authorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
