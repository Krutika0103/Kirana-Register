package com.kirana.transactions.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kirana.transactions.model.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository  extends MongoRepository<Transaction, String> {
	
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);


}
