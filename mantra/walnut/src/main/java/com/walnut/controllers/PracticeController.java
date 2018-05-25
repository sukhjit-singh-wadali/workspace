package com.walnut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walnut.model.PracticeModel;
import com.walnut.services.PracticeRepository;

@Controller
public class PracticeController {

	@Autowired
	PracticeRepository pracRepo;

	@GetMapping("/practice")
	@ResponseBody
	public ResponseEntity<PracticeModel> Practice() {
		PracticeModel practice = pracRepo.findOne("f");
		return new ResponseEntity<PracticeModel>(practice, HttpStatus.OK);
	}
}
