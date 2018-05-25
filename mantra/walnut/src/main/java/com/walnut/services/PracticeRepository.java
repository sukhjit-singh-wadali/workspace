package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.walnut.model.PracticeModel;

public interface PracticeRepository  extends MongoRepository<PracticeModel, String> {
	
	@Query("{'type':?0}")
	PracticeModel findOne(String t);
}
