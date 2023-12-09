package com.tawfeek.bookstore_customer.repository;

import com.tawfeek.bookstore_customer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
