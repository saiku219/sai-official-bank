package com.example.banking.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String type; // DEPOSIT, WITHDRAW, TRANSFER
    private LocalDateTime createdAt = LocalDateTime.now();

    // ✅ Required by JPA
    public Transaction() {}

    // ✅ Add this constructor (THIS fixes your error)
    public Transaction(Long fromAccountId, Long toAccountId, BigDecimal amount, String type) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getFromAccountId() { return fromAccountId; }
    public Long getToAccountId() { return toAccountId; }
    public BigDecimal getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}