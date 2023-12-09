package com.tawfeek.bookstore_admin.service;

import com.tawfeek.bookstore_admin.entity.Book;

import java.util.List;

public interface AdminBookService {


    List<Book> listAllBooks();

    void deleteBook(Long bookId);

    Book updateBook(Long id,Book book);

    Book addBook(Book book);

    Book setBookUnAvailable(Long id);

    Book setBookAvailable(Long id);

    List<Book> findBooksByCategory(Long categoryId);
}
