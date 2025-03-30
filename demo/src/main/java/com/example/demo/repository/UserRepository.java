package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable); // Add this method for pagination
    @Query(value="SELECT COUNT(*) FROM  user", nativeQuery=true)
    int countAllUsers();
}