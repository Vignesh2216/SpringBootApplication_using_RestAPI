package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Get admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Create a new admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update an existing admin
    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = adminRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Admin not found"));
        admin.setUsername(adminDetails.getUsername());
        admin.setEmail(adminDetails.getEmail());
        return adminRepository.save(admin);
    }

    // Delete an admin
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
    // public long countAllAdmins() {
    //     return adminRepository.countAllAdmins();
    // }

    public long countAllAdmins(){
        return adminRepository.countAllAdmins();
    }
}