package com.tawfeek.bookstore_admin.repository;

import com.tawfeek.bookstore_admin.entity.Book;
import com.tawfeek.bookstore_admin.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<List<Book>> findBookByCategory(Category category);
}
