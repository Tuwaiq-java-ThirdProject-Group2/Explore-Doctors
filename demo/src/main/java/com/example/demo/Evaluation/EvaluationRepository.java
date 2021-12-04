package com.example.demo.Evaluation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
//    List<String> getAllCommentByDoctId(Long doctorId);
//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//    User findByEmailAddress(String emailAddress);
}
