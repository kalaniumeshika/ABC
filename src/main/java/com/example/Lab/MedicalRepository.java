package com.example.Lab;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRepository extends MongoRepository<Medical, Integer> {
}
