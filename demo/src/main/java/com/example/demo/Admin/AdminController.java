package com.example.demo.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {
    public final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping()
    public Admin createAdmin(Admin a) {
        return adminService.createAdmin(a);
    }

    @DeleteMapping("/{id}")
    public Admin deleteAdmin(@PathVariable String id) {
        return adminService.deleteAdmin(id);
    }

    @PutMapping()
    public Admin updateAdmin(String id, Admin m) {
        return adminService.updateAdmin(id, m);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable String id) {
        return adminService.displayAdmin(id);
    }

    @GetMapping()
    public List<Admin> getAllAdmin() {
        return adminService.displayAllAdmin();
    }

}
