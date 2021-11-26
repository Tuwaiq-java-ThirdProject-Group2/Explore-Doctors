package com.example.demo.Hospital;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
 public interface HospitalRepository extends JpaRepository<Hospital,Long> {

}
