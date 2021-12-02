package com.example.demo.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository <Admin,Long>{
//    @Query(value = "select count(*) from admin")
//    public int number;
}
