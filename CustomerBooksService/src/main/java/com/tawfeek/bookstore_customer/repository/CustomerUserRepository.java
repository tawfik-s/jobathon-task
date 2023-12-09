package com.tawfeek.bookstore_customer.repository;

import com.tawfeek.bookstore_customer.entity.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerUserRepository extends JpaRepository<CustomerUser,Long> {

    @Query("select u from CustomerUser u where u.userName = :name")
    Optional<List<CustomerUser>> findByUserName(@Param("name")String userName);

    Optional<CustomerUser> findByEmail(String email);
}
