package com.example.InsuranceCardProject.Repository;

import com.example.InsuranceCardProject.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
