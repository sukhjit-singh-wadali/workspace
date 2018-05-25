package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.walnut.model.AnswerModel;

@Repository

public interface AnswerRepository extends MongoRepository<AnswerModel, String> {
	

	@Query("{ 'type' : ?0}")
	AnswerModel findOne(String t);

	@Query("{'question_id' : ?0}")
	AnswerModel findQuestion(String question_id);
}
