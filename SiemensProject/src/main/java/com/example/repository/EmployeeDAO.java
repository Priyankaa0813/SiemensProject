package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EmployeeEntity;

@Repository
public interface EmployeeDAO extends JpaRepository<EmployeeEntity, Long> {

}
