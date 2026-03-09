package com.boss.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", allocationSize = 1)
	 private Long id;
      @Column(name="name")
      private String name;
      
      @Column(name="student_class")
      private String studentClass;
      
      @Column(name="address")
      private String address;
}
