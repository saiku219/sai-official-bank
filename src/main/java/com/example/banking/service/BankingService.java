package com.example.banking.service;

import com.example.banking.dto.CreateAccountRequest;
import com.example.banking.dto.TransferRequest;
import com.example.banking.model.Account;
import com.example.banking.model.Transaction;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankingService {

    private final AccountRepository accountRepo;
    private final TransactionRepository txnRepo;

    public BankingService(AccountRepository accountRepo, TransactionRepository txnRepo) {
        this.accountRepo = accountRepo;
        this.txnRepo = txnRepo;
    }

    public Account createAccount(CreateAccountRequest req) {
        Account acc = new Account();
        acc.setOwnerName(req.getOwnerName());
        acc.setType(req.getType());
        acc.setBalance(req.getInitialBalance() == null ? BigDecimal.ZERO : req.getInitialBalance());
        return accountRepo.save(acc);
    }

    public void transfer(TransferRequest req) {
        withdraw(req.getFromAccountId(), req.getAmount());
        deposit(req.getToAccountId(), req.getAmount());
        txnRepo.save(new Transaction(req.getFromAccountId(), req.getToAccountId(), req.getAmount(), "TRANSFER"));
    }

    public Account deposit(Long id, BigDecimal amount) {
        Account acc = accountRepo.findById(id).orElseThrow();
        acc.setBalance(acc.getBalance().add(amount));
        txnRepo.save(new Transaction(null, id, amount, "DEPOSIT"));
        return accountRepo.save(acc);
    }

    public Account withdraw(Long id, BigDecimal amount) {
        Account acc = accountRepo.findById(id).orElseThrow();
        if (acc.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        acc.setBalance(acc.getBalance().subtract(amount));
        txnRepo.save(new Transaction(id, null, amount, "WITHDRAW"));
        return accountRepo.save(acc);
    }
    public List<Transaction> getTransactionsForAccount(Long accountId) {
        return txnRepo.findByFromAccountIdOrToAccountId(accountId, accountId);
    }
}