package com.ra.service;

import com.ra.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IAuthorService {
    List<Author> findAll();
    Author create(Author author);
    Author findById(int id);
    Author update(Author author, int id);
    void delete(int id);
}
