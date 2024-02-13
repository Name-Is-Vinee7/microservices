package com.example.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {

}
