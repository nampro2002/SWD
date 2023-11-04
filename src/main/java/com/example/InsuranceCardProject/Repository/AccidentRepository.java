package com.example.InsuranceCardProject.Repository;

import com.example.InsuranceCardProject.Entity.Accident;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccidentRepository extends JpaRepository<Accident, Integer> {
    @Query("SELECT c FROM Accident c WHERE c.Participant.id = :userId")
    List<Accident> findByParId(@Param("userId") Integer id);
}
