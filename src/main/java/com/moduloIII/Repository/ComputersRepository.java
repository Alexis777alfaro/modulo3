package com.moduloIII.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.moduloIII.collections.Computers;
import com.moduloIII.collections.Sequence;

public interface ComputersRepository extends MongoRepository<Computers,String>{
	  @Query(value = "{ 'id' : 'computers' }", fields = "{ 'seq' : 1}")
	    Sequence findSequence();
}
