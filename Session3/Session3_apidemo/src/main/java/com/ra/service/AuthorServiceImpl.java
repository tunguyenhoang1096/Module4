package com.ra.service;

import com.ra.model.Author;
import com.ra.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImpl implements IAuthorService{
    @Autowired
    private AuthorRepository authorRepository;
    @Override
    public List<Author> findAll() {
        return authorRepository.getAuthors();
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author update(Author author,int id) {
        return authorRepository.update(author,id);
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);
    }

}
