package com.mcnichol.entity;

import com.mcnichol.exception.NegativeBalanceException;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    public SavingsAccount() throws NegativeBalanceException {
        super();
    }

    public SavingsAccount(BigDecimal initialBalance) throws NegativeBalanceException {
        super(initialBalance);
    }
}
