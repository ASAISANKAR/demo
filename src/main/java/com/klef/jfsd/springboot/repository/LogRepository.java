package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Log;

public interface LogRepository extends JpaRepository<Log, Integer>{
	

}
