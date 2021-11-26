package com.example.demo.User;



import com.example.demo.Admin.Admin;
import com.example.demo.Evaluation.Evaluation;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserId;
    private String name;
    private String Email;
    private Long Phone;
    private int passwords;
    private boolean Active;
    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admin admin;
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,targetEntity = Evaluation.class)
    Set User= new HashSet();


    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    public int getPasswords() {
        return passwords;
    }

    public void setPasswords(int passwords) {
        this.passwords = passwords;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}

