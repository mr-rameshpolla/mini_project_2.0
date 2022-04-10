package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.empolyee;

public interface EmployeeRepo extends JpaRepository<empolyee,Long> {

	Optional<empolyee> findById(Long id);

//	Optional<empolyee> deleteById(Long id);

}
