package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.walnut.model.BasicAnswerModel;
@Repository

public interface BasicAnswerRepository extends MongoRepository<BasicAnswerModel, String> {
	
	@Override
	BasicAnswerModel findOne(String id);
	
	@Query("{ 'userId' : ?0}")
	BasicAnswerModel find(String userid);


}
