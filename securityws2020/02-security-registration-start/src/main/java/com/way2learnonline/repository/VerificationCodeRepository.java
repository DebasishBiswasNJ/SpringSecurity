package com.way2learnonline.repository;

import org.springframework.data.repository.CrudRepository;

import com.way2learnonline.model.Verification;

public interface VerificationCodeRepository extends CrudRepository<Verification, Long>{
	
	Verification findByUsername(String username);
	boolean existsByUsername(String username);
}
