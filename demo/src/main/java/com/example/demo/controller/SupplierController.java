package com.example.demo.controller;
import com.example.demo.entity.Supplier;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController// @RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/supplier/get")
    public Page<Supplier> getAllSuppliers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDir) {
            return supplierService.getAllSuppliers(page, size, sortBy, sortDir);
        }

        @GetMapping("/supplier/search/name")
        public List<Supplier> findByNameContainingIgnoreCase(@RequestParam String name) {
            return supplierService.findByNameContainingIgnoreCase(name);
        }
        @GetMapping("/supplier/get/{id}")
        public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
            return supplierService.getSupplierById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
        }

        @PostMapping("/supplier/add")
        public Supplier createSupplier(@RequestBody Supplier supplier) {
            return supplierService.createSupplier(supplier);
        }

        @PutMapping("/supplier/put/{id}")
        public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplierDetails) {
            return ResponseEntity.ok(supplierService.updateSupplier(id, supplierDetails));
        }

        @DeleteMapping("/supplier/del/{id}")
        public String deleteSupplier(@PathVariable Long id) {
            supplierService.deleteSupplier(id);
            return "Succesful";
        }
    }