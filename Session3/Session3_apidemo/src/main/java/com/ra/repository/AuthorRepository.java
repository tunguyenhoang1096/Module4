package com.ra.repository;

import com.ra.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AuthorRepository {
    private List<Author> authors = new ArrayList<>(); // khai báo danh sách chứa thông tin tác giả
    // Khởi tạo 3 tác giả và thêm vào danh sách
    public AuthorRepository() {
        Author author1 = new Author(1,"Hoàng Tú","tu@gmail.com");
        Author author2 = new Author(2,"Linh","linh@gmail.com");
        Author author3 = new Author(3,"Đại Nghĩa","nghia@gmail.com");
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
    }
    //phương thức trả về danh sách tác giả
    public List<Author> getAuthors() {
        return authors;
    }

    // ex2: thêm mới
    public Author save(Author author) {
        authors.add(author);
        return author;
    }

    //ex3: Tìm theo id
    public Author findById(int id) {
        for (Author author : authors) {
            if (author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    //ex4: cập nhật
    public Author update(Author author, int id) {
        int index = -1;
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getId() == author.getId()) {
                index = i;
            }
        }
        if (index != -1) {
            authors.set(index, author);
            return author;
        }
        return null;
    }

    //ex5: Xóa theo id
    public void deleteById(int id) {
        Author author = findById(id);
        if (author != null) {
            authors.remove(author);
        }
    }
}
