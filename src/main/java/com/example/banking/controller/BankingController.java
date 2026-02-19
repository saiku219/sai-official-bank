package com.example.banking.controller;

import com.example.banking.dto.CreateAccountRequest;
import com.example.banking.dto.TransferRequest;
import com.example.banking.model.Account;
import com.example.banking.model.Transaction;
import com.example.banking.service.BankingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BankingController {

    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/accounts")
    public Account create(@Valid @RequestBody CreateAccountRequest req) {
        return bankingService.createAccount(req);
    }

    @PostMapping("/accounts/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return bankingService.deposit(id, amount);
    }

    @PostMapping("/accounts/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestParam BigDecimal amount) {
        return bankingService.withdraw(id, amount);
    }

    @PostMapping("/accounts/transfer")
    public String transfer(@RequestBody TransferRequest req) {
        bankingService.transfer(req);
        return "Transfer successful";
    }

    @GetMapping("/accounts/{id}/transactions")
    public List<Transaction> history(@PathVariable Long id) {
        return bankingService.getTransactionsForAccount(id);
    }
}