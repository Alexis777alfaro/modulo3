package com.moduloIII.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.moduloIII.collections.Users;


public interface usersRepository extends MongoRepository<Users, String> {
	void deleteByEmail(String email);
	
	@Query("{ 'email' : ?0 }")
    Users findByEmail(String email);
}
