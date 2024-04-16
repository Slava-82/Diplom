package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {
/*
    @Test
    void ShouldCreateSavingAccountRateMinus1() {
        SavingAccount savingAcc = new SavingAccount(
                0,
                0,
                50_000,
                -1
        );
        //Assertions.assertEquals(0, savingAcc.getRate());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.getRate();
        });
    }

 */

    @Test
    void ShouldCreateSavingAccount() {
        SavingAccount savingAcc = new SavingAccount(
                0,
                0,
                50_000,
                5
        );
        Assertions.assertEquals(0, savingAcc.getBalance());
        Assertions.assertEquals(0, savingAcc.getMinBalance());
        Assertions.assertEquals(50_000, savingAcc.getMaxBalance());
        Assertions.assertEquals(5, savingAcc.getRate());
    }

    @Test
    void pay() {
        SavingAccount savingAcc = new SavingAccount(
                0,
                0,
                50_000,
                10
        );

    }

    @Test
    void add() {
    }

    @Test
    void yearChange() {
    }

}

