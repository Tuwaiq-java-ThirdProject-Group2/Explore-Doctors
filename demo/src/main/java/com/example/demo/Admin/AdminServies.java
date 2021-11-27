package com.example.demo.Admin;

import com.example.demo.Evaluation.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServies {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServies(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdmin(String id) {
        Long admin_id = Long.parseLong(id);
        return adminRepository.findById(admin_id).orElse(null);
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public void deleteAdmin(String id) {
        Long admin_id = Long.parseLong(id);
        adminRepository.deleteById(admin_id);
    }

    public void updateAdmin(String id, Admin data) {
        Long admin_id = Long.parseLong(id);
        Admin admin = adminRepository.findById(admin_id).orElse(null);
        if (admin != null) {
            admin.setUserName(data.getUserName());
            admin.setPassword(data.getPassword());
            admin.setRole(data.getRole());

        }

    }


}

