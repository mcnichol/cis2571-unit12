package com.mcnichol.entity;

import com.mcnichol.exception.NegativeBalanceException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class CheckingAccount extends Account{
    public CheckingAccount() throws NegativeBalanceException {
        super();
    }

    public CheckingAccount(BigDecimal initialBalance) throws NegativeBalanceException {
        super(initialBalance);
    }

}
