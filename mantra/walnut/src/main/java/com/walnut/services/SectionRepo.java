package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.walnut.model.SectionModel;

public interface SectionRepo extends MongoRepository<SectionModel, String> {

	@Query("{ 'userId' : ?0}")
	SectionModel findSection(String a);

}