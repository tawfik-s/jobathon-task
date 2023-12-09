package com.tawfeek.bookstore_admin.controller;


import com.tawfeek.bookstore_admin.entity.Book;
import com.tawfeek.bookstore_admin.service.AdminBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class AdminBookController {

    @Autowired
    private AdminBookService adminBookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return adminBookService.listAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return adminBookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        adminBookService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book book){
       return adminBookService.updateBook(id,book);
    }

    @PutMapping("/un_available/{id}")
    public Book setUnAvailable(@PathVariable Long id){
        return adminBookService.setBookUnAvailable(id);
    }

    @PutMapping("/available/{id}")
    public Book setAvailable(@PathVariable Long id){
        return adminBookService.setBookAvailable(id);
    }

    @GetMapping("/categories/{id}")
    public List<Book> getBooksByCategory(@PathVariable Long id){
        return adminBookService.findBooksByCategory(id);
    }
}
