package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Log;
import com.klef.jfsd.springboot.repository.LogRepository;


@Service
public class LogServiceImplementation implements LogService{
	@Autowired
	private LogRepository logrepo;

	@Override
	public String LogRegistration(Log log) {
		logrepo.save(log);
		return "Log Saved";
	}

}
