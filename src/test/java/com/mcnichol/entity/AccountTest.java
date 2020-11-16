package com.mcnichol.entity;

import com.mcnichol.exception.NegativeBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account subject;

    @BeforeEach
    public void setup() {
        try {
            subject = new Account();
        } catch (NegativeBalanceException e) {
            fail();
        }
    }

    @Test
    public void givenAccount_whenUsingDefaultConstructor_balanceIsZero() {
        System.out.println(subject.getCurrentBalance());

        BigDecimal actual = subject.getCurrentBalance();

        BigDecimal expected = BigDecimal.ZERO;
        assertEquals(expected, actual);
    }

    @Test
    public void givenAccount_whenInitializingWith10_balanceIs10() {
        try {
            subject = new Account(new BigDecimal("10"));
        } catch (NegativeBalanceException e) {
            fail();
        }

        BigDecimal actual = subject.getCurrentBalance();
        BigDecimal expected = new BigDecimal("10");

        assertEquals(expected, actual);
    }

    @Test
    public void givenAccountWith0_whenCredited10_balanceIs10() {
        BigDecimal amountToCredit = new BigDecimal("10");

        subject.credit(amountToCredit);
        BigDecimal actual = subject.getCurrentBalance();

        BigDecimal expected = new BigDecimal("10");
        assertEquals(expected, actual);
    }

    @Test
    public void givenAccount_whenCredited0_throwsUnsupportedOperationException() {
        UnsupportedOperationException actualException = assertThrows(UnsupportedOperationException.class, () -> subject.credit(new BigDecimal("0")));

        String actual = actualException.getMessage();

        String expected = "Credit must be greater than 0.\nCredit Amount: 0";
        assertEquals(expected, actual);
    }
}