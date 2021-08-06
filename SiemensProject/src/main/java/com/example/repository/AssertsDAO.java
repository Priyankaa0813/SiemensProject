package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.AssertsEntity;

@Repository
public interface AssertsDAO extends JpaRepository<AssertsEntity, Long> {

}
