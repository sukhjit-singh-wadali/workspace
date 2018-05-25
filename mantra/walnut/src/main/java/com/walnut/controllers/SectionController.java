package com.walnut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.walnut.model.AbstractResponse;
import com.walnut.model.BasicAnswerModel;
import com.walnut.model.SectionModel;
import com.walnut.services.BasicAnswerRepository;
import com.walnut.services.SectionRepo;

@RestController
public class SectionController {

	@Autowired
	BasicAnswerRepository basicAnsRepo;

	@Autowired
	SectionRepo sectionRepo;

	@PostMapping("/submitted")
	@ResponseBody
	public ResponseEntity<? extends AbstractResponse> login(@RequestBody BasicAnswerModel basicAnswerModel) {
		AbstractResponse abstractResponse = new AbstractResponse();
		System.out.println(basicAnswerModel.getUserId());
		BasicAnswerModel ans = basicAnsRepo.find(basicAnswerModel.getUserId());
		System.out.println(new Gson().toJson(ans));
		if (ans != null) {
			abstractResponse.setMessage("complete");
			return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.OK);

		} else {
			abstractResponse.setMessage("incomplete");
			return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.OK);
		}

	}

	@GetMapping("/getSections")
	@ResponseBody
	public ResponseEntity<? extends AbstractResponse> getSection(String userId) {
		SectionModel sectionModel = sectionRepo.findSection(userId);
		if (sectionModel == null) {
			sectionModel = new SectionModel();
			sectionModel.setMessage("Nothing is assign to this user");
			return new ResponseEntity<AbstractResponse>(sectionModel, HttpStatus.FORBIDDEN);

		}
		return new ResponseEntity<AbstractResponse>(sectionModel, HttpStatus.OK);
	}
	
	
	

}
