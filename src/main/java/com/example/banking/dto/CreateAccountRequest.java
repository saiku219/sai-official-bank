package com.example.banking.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {
    private String ownerName;
    private String type;
    private BigDecimal initialBalance;

    public String getOwnerName() { return ownerName; }
    public String getType() { return type; }
    public BigDecimal getInitialBalance() { return initialBalance; }

    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }
    public void setType(String type) { this.type = type; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
}