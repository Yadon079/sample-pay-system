package com.grace.pay.userservice.repository;

import com.grace.pay.userservice.domain.PayUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PayUserRepository extends MongoRepository<PayUser, String> {

}