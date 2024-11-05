package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.React;
import com.klef.jfsd.springboot.repository.ReactRepository;

@Service
public class ReactServiceImplementation implements ReactService{
	@Autowired
	private ReactRepository react;

	@Override
	public String ReactRegistration(React react) {
		this.react.save(react);
		return "Saved";
	}
	

}
