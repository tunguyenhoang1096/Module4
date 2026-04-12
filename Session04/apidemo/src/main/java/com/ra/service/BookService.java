package com.ra.service;

import com.ra.model.dto.BookRequest;
import com.ra.model.entity.Author;
import com.ra.model.entity.Book;
import com.ra.repository.AuthorRepository;
import com.ra.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public ResponseEntity<?> addBook(BookRequest bookRequest) {
        // kiểm tra tồn tại tác giả
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);
        if (author == null) {
            return new ResponseEntity<>("Tác giả không tồn tại", HttpStatus.BAD_REQUEST);
        }else
            {
            Book book = new Book();
            book.setAuthor(author);
            book.setTitle(bookRequest.getTitle());
            book.setPrice(bookRequest.getPrice());
            return new ResponseEntity<>(bookRepository.save(book), HttpStatus.OK);
            }
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}
