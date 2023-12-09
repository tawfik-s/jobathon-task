package com.tawfeek.bookstore_admin.service.Impl;

import com.tawfeek.bookstore_admin.entity.Book;
import com.tawfeek.bookstore_admin.entity.Category;
import com.tawfeek.bookstore_admin.repository.BookRepository;
import com.tawfeek.bookstore_admin.repository.CategoryRepository;
import com.tawfeek.bookstore_admin.service.AdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminBookServiceImpl implements AdminBookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book updateBook(Long id,Book newBook) {
        Book book=bookRepository.findById(id).orElseThrow();
        book.setAvailability(true);
        return bookRepository.save(newBook);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book setBookUnAvailable(Long id) {
        Book book=bookRepository.findById(id).orElseThrow();
        book.setAvailability(true);
        return bookRepository.save(book);
    }

    @Override
    public Book setBookAvailable(Long id) {
        Book book=bookRepository.findById(id).orElseThrow();
        book.setAvailability(false);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooksByCategory(Long categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow();
        return bookRepository.findBookByCategory(category).orElse(null);
    }
}
