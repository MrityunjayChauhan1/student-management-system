package com.boss.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boss.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
