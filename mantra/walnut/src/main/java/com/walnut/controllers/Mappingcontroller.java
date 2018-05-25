package com.walnut.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.walnut.services.MappingRepository;

@RestController
public class Mappingcontroller{
	
	@Autowired
	MappingRepository mappingRepo;
	

	
	
}
