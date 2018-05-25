package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.walnut.model.QuestionModel;

@Repository
public interface QuestionRepository extends MongoRepository<QuestionModel, String> {
	@Override
	QuestionModel findOne(String id);
	
	@Query("{ 'type' : ?0}")
	QuestionModel findQuestion(String a);
	}
