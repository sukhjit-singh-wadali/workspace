package com.walnut.services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.walnut.model.UserprofileModel;

public interface UserProfileRepo extends MongoRepository<UserprofileModel, String> {
	@Override
	UserprofileModel findOne(String id);
	@Query("{ 'userId' : ?0}")
	UserprofileModel findUserProfile(String a);
	
}