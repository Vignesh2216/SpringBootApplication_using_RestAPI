package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get all admins
    @GetMapping("/admin/get")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // Get admin by ID
    // @GetMapping("/admin/get/{id}")
    // public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        //     return adminService.getAdminById(.map(ResponseEntity::ok.orElse(ResponseEntity.notFound().build());
        // }
        
        // Create a new admin
        @PostMapping("/admin/add")
        public Admin createAdmin(@RequestBody Admin admin) {
            return adminService.createAdmin(admin);
        }

        // Update an existing admin
        @PutMapping("/admin/put/{id}")
        public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
            return ResponseEntity.ok(adminService.updateAdmin(id, adminDetails));
        }

        // Delete an admin
        @DeleteMapping("/admin/del/{id}")
        public String deleteAdmin(@PathVariable Long id) {
            adminService.deleteAdmin(id);
            return "Successfully deleted";
        }
        // @GetMapping("/admin/count")
        // public long countAllAdmins() {
        //     return adminService.countAllAdmins();
        // }

        @GetMapping("/admin/count")
        public long countAllAdmins(){
            return adminService.countAllAdmins();
        }
    }