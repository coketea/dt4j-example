package com.coketea.dt.example.participant2.repository;

import com.coketea.dt.example.participant2.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
}
