package com.walnut.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.walnut.model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {

	@Override
	UserModel findOne(String id);

	@Query("{ 'email' : ?0 , 'password':?1 }")
	UserModel findUser(String a, String b);

	@Query("{ 'email' : ?0}")
	UserModel findUser(String a);
}
