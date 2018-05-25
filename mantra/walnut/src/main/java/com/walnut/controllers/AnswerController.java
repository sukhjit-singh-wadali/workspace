package com.walnut.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.walnut.model.AbstractResponse;
import com.walnut.model.AnswerModel;
import com.walnut.model.BasicAnswerModel;
import com.walnut.model.MappingModel;
import com.walnut.model.QuestionModel;
import com.walnut.model.SectionModel;
import com.walnut.model.SectionModel.Section;
import com.walnut.services.AnswerRepository;
import com.walnut.services.BasicAnswerRepository;
import com.walnut.services.MappingRepository;
import com.walnut.services.QuestionRepository;
import com.walnut.services.SectionRepo;

@RestController
public class AnswerController {

	@Autowired
	AnswerRepository answerRepo;
	@Autowired
	MappingRepository mappingRepo;
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	BasicAnswerRepository basicAnswerRepo;

	@Autowired
	SectionRepo sectionRepo;

	@PostMapping("/programAnswers")
	@ResponseBody
	public ResponseEntity<? extends AbstractResponse> Progarm(@RequestBody AnswerModel answerModel) {
		AbstractResponse abstractResponse = new AbstractResponse();
		answerRepo.insert(answerModel);
		
		SectionModel sectionModel = sectionRepo.findSection(answerModel.getUser_id());
		sectionRepo.delete(sectionModel);
		
		
		List<Section> list = sectionModel.getSectionList();
		for (Section section : list) {
			if (section.getSectionType().equals("programming"))
				section.setStatus("completed");
		}
		sectionRepo.insert(sectionModel);

		abstractResponse.setMessage("submitted");
		MappingModel mappingModel = mappingRepo.find("basic");
		QuestionModel questionModel;
		for (int i = 0; i < mappingModel.getFlow().size(); i++) {
			String curentQuesId = mappingModel.getFlow().get(i).getCurrent_question();
			if (curentQuesId.equals(answerModel.getQuestion_id())) {
				String nextQuestion = mappingModel.getFlow().get(i).getNext_question();
				questionModel = questionRepo.findOne(nextQuestion);
				System.out.println(new Gson().toJson(questionModel));
				if (questionModel != null) {
					return new ResponseEntity<QuestionModel>(questionModel, HttpStatus.OK);
				}
				if (questionModel == null) {
					AbstractResponse abstractResponse2 = new AbstractResponse();
					abstractResponse2.setMessage("complete");
					return new ResponseEntity<AbstractResponse>(abstractResponse2, HttpStatus.OK);

				}
			}
		}
		abstractResponse.setMessage("error");

		return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/basicProgramAnswers")
	@ResponseBody
	public ResponseEntity<? extends AbstractResponse> BasicAnswers(@RequestBody BasicAnswerModel basicAnswerModel) {

		basicAnswerRepo.insert(basicAnswerModel);

		SectionModel sectionModel = sectionRepo.findSection(basicAnswerModel.getUserId());
		sectionRepo.delete(sectionModel);
		
		
		List<Section> list = sectionModel.getSectionList();
		for (Section section : list) {
			if (section.getSectionType().equals("basic"))
				section.setStatus("completed");
		}
		sectionRepo.insert(sectionModel);

		System.out.println(new Gson().toJson(basicAnswerModel));

		AbstractResponse abstractResponse = new AbstractResponse();
		abstractResponse.setMessage("success");

		return new ResponseEntity<AbstractResponse>(abstractResponse, HttpStatus.OK);

	}

}
