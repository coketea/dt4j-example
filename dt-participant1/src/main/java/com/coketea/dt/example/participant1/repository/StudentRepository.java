package com.coketea.dt.example.participant1.repository;

import com.coketea.dt.example.participant1.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
