package com.moduloIII.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moduloIII.collections.Sequence;

public interface SequenceRepository extends MongoRepository<Sequence, String>  {

}
