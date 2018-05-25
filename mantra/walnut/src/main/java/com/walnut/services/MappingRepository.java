package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.walnut.model.MappingModel;

public interface MappingRepository  extends MongoRepository<MappingModel, String>{
	
	@Query("{'section':?0}")
	MappingModel find(String section);
}
