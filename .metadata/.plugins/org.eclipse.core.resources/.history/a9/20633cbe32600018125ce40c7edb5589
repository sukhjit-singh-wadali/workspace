package com.walnut.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walnut.model.AbstractResponse;
import com.walnut.model.QuestionModel;
import com.walnut.model.QuestionnaireModel;
import com.walnut.services.QuestionRepository;
import com.walnut.services.QuestionnaireRepository;

@RestController
public class QuestionController {

	@Autowired
	QuestionRepository questionRepo;

	@Autowired
	QuestionnaireRepository questionnaireRepo;

	@GetMapping("/getQuestions")
	@ResponseBody
	public ResponseEntity<? extends AbstractResponse> GetQuestions(String type) {
		if (type == null) {
			AbstractResponse abstractResponse = new AbstractResponse();
			abstractResponse.setMessage("type undefined");
			return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.FORBIDDEN);
		} else if (type.equals("programming")) {
			QuestionModel questionModel = questionRepo.findQuestion("program");
			return new ResponseEntity<AbstractResponse>(questionModel, HttpStatus.OK);
		} else if (type.equals("basic")) {
			QuestionnaireModel questionnaireModel = questionnaireRepo.findAll("basic");
			return new ResponseEntity<AbstractResponse>(questionnaireModel, HttpStatus.OK);
		} else {
			AbstractResponse abstractResponse = new AbstractResponse();
			abstractResponse.setMessage("Something went wrong");
			return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.FORBIDDEN);
		}

	}

	

}
