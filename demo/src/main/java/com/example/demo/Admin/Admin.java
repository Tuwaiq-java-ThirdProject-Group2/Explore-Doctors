package com.example.demo.Admin;

import javax.persistence.*;

@Entity
@Table(name = "Admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long adminId;
    private String user_name;
    private String password;
    private String role;

    public Admin(Long adminId, String user_name, String password, String role) {
        this.adminId = adminId;
        this.user_name = user_name;
        this.password = password;
        this.role = role;
    }

    public Admin() {
    }

    public Long getId() {
        return adminId;
    }

    public void setId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
