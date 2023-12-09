package com.tawfeek.bookstore_customer.service;

import com.tawfeek.bookstore_customer.entity.BorrowRequest;

public interface BorrowRequestService {

    BorrowRequest addBorrowRequest(BorrowRequest borrowRequest);

    void deleteBorrowRequest(Long id);
}
