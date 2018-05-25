package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.walnut.model.Languages;

@Repository
public interface LanguageRepository extends MongoRepository<Languages, String> {
	
	@Query("{ 'type' : ?0}")
	Languages findOne(String t);

}