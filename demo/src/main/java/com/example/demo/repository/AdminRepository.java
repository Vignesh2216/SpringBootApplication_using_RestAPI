package com.example.demo.repository;

import com.example.demo.entity.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // @Query("SELECT COUNT(a) FROM Admin a")
    // long countAllAdmins();

    @Query("SELECT COUNT(a) FROM Admin a")
    long countAllAdmins();
}