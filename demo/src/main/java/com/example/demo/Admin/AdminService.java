package com.example.demo.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    public final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin createAdmin(Admin a) {
        return adminRepository.save(a);
    }

    public Admin updateAdmin(String id, Admin a) {
        Long Admin_id = Long.parseLong(id);
        Admin currentAdmin = adminRepository.findById(Admin_id).orElse(null);
        if (currentAdmin != null) {
            currentAdmin.setPassword(a.getPassword());
            currentAdmin.setUserName(a.getUserName());
            adminRepository.save(currentAdmin);
        }
        return currentAdmin;
    }

    public Admin deleteAdmin(String id) {
        Long Admin_id = Long.parseLong(id);
        Admin currentAdmin = adminRepository.findById(Admin_id).orElse(null);
        return currentAdmin;
    }

    public Admin displayAdmin(String id) {
        Long admin_id = Long.parseLong(id);
        return adminRepository.getById(admin_id);
    }

    public List<Admin> displayAllAdmin() {
        return adminRepository.findAll();
    }
}
