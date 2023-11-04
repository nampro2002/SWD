package com.example.InsuranceCardProject.Repository;

import com.example.InsuranceCardProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
