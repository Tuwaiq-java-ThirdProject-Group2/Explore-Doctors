package com.example.demo.Evaluation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
//@Query(value="SELECT AVG(rate), DOCTORID FROM  EVALUATIONS  JOIN DOCTOR  ON EVALUATIONS.DO
//   @Query("select e from evaluations  e where e.rate=:r ")

//   @Query("SELECT AVG(rate), doctor-id from evaluations where videoId=:videoId")
//   public double findAverageByDoctorId(@Param("doctor-id") long videoId);


//    List<Evaluation> getAllByRate(double rate);
}
