package com.example.banking.service;

import com.example.banking.dto.CreateAccountRequest;
import com.example.banking.dto.TransferRequest;
import com.example.banking.model.Account;
import com.example.banking.model.Transaction;
import com.example.banking.repository.AccountRepository;
import com.example.banking.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankingService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public BankingService(AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    // ✅ FIX: This method was missing (caused your error)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // ✅ Create new account
    public Account createAccount(CreateAccountRequest request) {
        Account account = new Account();
        account.setOwnerName(request.ownerName);
        account.setType(request.type);
        account.setBalance(request.initialBalance);
        return accountRepository.save(account);
    }

    // ✅ Transfer money + save transaction
    @Transactional
    public void transfer(TransferRequest request) {
        Account from = accountRepository.findById(request.fromAccountId)
                .orElseThrow(() -> new RuntimeException("From account not found"));

        Account to = accountRepository.findById(request.toAccountId)
                .orElseThrow(() -> new RuntimeException("To account not found"));

        if (from.getBalance().compareTo(request.amount) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        from.setBalance(from.getBalance().subtract(request.amount));
        to.setBalance(to.getBalance().add(request.amount));

        Transaction tx = new Transaction();
        tx.setFromAccountId(request.fromAccountId);
        tx.setToAccountId(request.toAccountId);
        tx.setAmount(request.amount);
        tx.setType("TRANSFER");

        transactionRepository.save(tx);
    }
}