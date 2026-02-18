package com.example.banking.controller;

import com.example.banking.dto.CreateAccountRequest;
import com.example.banking.dto.TransferRequest;
import com.example.banking.model.Account;
import com.example.banking.model.Transaction;
import com.example.banking.service.BankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    // ✅ Create new bank account
    @PostMapping
    public Account createAccount(@RequestBody CreateAccountRequest request) {
        return bankingService.createAccount(
                request.getOwnerName(),
                request.getType(),
                request.getInitialBalance()
        );
    }

    // ✅ Get all accounts
    @GetMapping
    public List<Account> getAllAccounts() {
        return bankingService.getAllAccounts();
    }

    // ✅ Transfer money
    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransferRequest request) {
        return bankingService.transfer(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
    }

    // ✅ Get transaction history for one account
    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long accountId) {
        return bankingService.getTransactionsForAccount(accountId);
    }
}