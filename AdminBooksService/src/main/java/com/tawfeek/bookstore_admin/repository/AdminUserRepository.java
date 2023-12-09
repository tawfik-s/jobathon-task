package com.tawfeek.bookstore_admin.repository;

import com.tawfeek.bookstore_admin.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,Long> {

    @Query("select u from AdminUser u where u.userName = :name")
    Optional<List<AdminUser>> findByUserName(@Param("name")String userName);

    Optional<AdminUser> findByEmail(String email);
}
