package com.example.InsuranceCardProject.Repository;

import com.example.InsuranceCardProject.Entity.Accident;
import com.example.InsuranceCardProject.Entity.Compensation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompensationRepository extends JpaRepository<Compensation, Integer> {

    @Query("SELECT c FROM Compensation c WHERE c.Accident.id = :id")
    List<Compensation> findByAccidentId(@Param("id") Integer id);
}
