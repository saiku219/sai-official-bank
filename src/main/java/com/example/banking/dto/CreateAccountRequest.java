package com.example.banking.dto;

import java.math.BigDecimal;

public class CreateAccountRequest {

    private String ownerName;
    private String type;
    private BigDecimal initialBalance;

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public BigDecimal getInitialBalance() { return initialBalance; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
}