package com.tawfeek.bookstore_customer.repository;

import com.tawfeek.bookstore_customer.entity.BorrowRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRequestRepository extends JpaRepository<BorrowRequest,Long> {
}
