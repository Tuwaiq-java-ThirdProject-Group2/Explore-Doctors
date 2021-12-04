package com.example.demo.Evaluation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
//@Query(value="SELECT AVG(rate), DOCTORID FROM  EVALUATIONS  JOIN DOCTOR  ON EVALUATIONS.DOCTORID
=======
import java.util.List;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
//    List<String> getAllCommentByDoctId(Long doctorId);
>>>>>>> 5365cbb84559216823ef653d6043447f9f97cc6a
//    @Query(value = "SELECT * FROM USERS WHERE EMAIL_ADDRESS = ?1", nativeQuery = true)
//    User findByEmailAddress(String emailAddress);
}
