package com.walnut.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.walnut.model.Languages;
import com.walnut.services.LanguageRepository;

@RestController
public class LanguagesController {

	@Autowired
	LanguageRepository langRepo;

	@GetMapping("/languages")
	@ResponseBody
	public ResponseEntity<Languages> getLanguages() {

		Languages languages = langRepo.findOne("common");
		return new ResponseEntity<Languages>(languages, HttpStatus.OK);

	}
}
