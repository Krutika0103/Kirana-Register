package com.kirana.transactions.controller;
import org.springframework.web.bind.annotation.*;

import com.kirana.transactions.model.FinancialReport;
import com.kirana.transactions.model.Transaction;
import com.kirana.transactions.service.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/report")
    public FinancialReport getReport(@RequestParam String period) {
        LocalDateTime start;
        LocalDateTime end = LocalDateTime.now();

        // Adjust start based on period (weekly, monthly, yearly)
        switch (period) {
            case "weekly":
                start = end.minusWeeks(1);
                break;
            case "monthly":
                start = end.minusMonths(1);
                break;
            case "yearly":
                start = end.minusYears(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid period");
        }

        List<Transaction> transactions = transactionService.getTransactions(start, end);
        return new FinancialReport();
    }
}
