package com.kirana.transactions.service;

import org.springframework.stereotype.Service;

import com.kirana.transactions.model.Transaction;
import com.kirana.transactions.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

	private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public List<Transaction> getTransactions(LocalDateTime start, LocalDateTime end) {
        return repository.findByTimestampBetween(start, end);
    }

    public BigDecimal calculateTotalCredits(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tx -> tx.getType().equalsIgnoreCase("credit"))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateTotalDebits(List<Transaction> transactions) {
        return transactions.stream()
                .filter(tx -> tx.getType().equalsIgnoreCase("debit"))
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
