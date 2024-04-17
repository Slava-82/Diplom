package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    /**
     * Тестируенм создание нового объекта сберегательного счёта с заданными параметрами.
     */
    @Test
    void ShouldCreateSavingAccount() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertEquals(1000, savingAcc.getBalance());
        Assertions.assertEquals(0, savingAcc.getMinBalance());
        Assertions.assertEquals(50_000, savingAcc.getMaxBalance());
        Assertions.assertEquals(5, savingAcc.getRate());
    }

    @Test
    void ShouldNotCreateSavingAccountRateMinus1() {
        SavingAccount savingAcc = new SavingAccount(
                0,
                0,
                50_000,
                -1
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.getRate();
        });
    }

    @Test
    void ShouldNotCreateSavingAccountMinBalanceGreaterMaxBalance() {
        SavingAccount savingAcc = new SavingAccount(
                3_000,
                10_000,
                5_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.getMinBalance();
        });
    }

    @Test
    void ShouldNotCreateSavingAccountInitialBalanceGreaterMaxBalance() {
        SavingAccount savingAcc = new SavingAccount(
                60_000,
                1_000,
                50_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.getBalance();
        });
    }

    @Test
    void ShouldNotCreateSavingAccountInitialBalanceLessMinBalance() {
        SavingAccount savingAcc = new SavingAccount(
                3_000,
                10_000,
                50_000,
                5
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            savingAcc.getBalance();
        });
    }

    /**
     * Тестируенм медод Пей
     */
    @Test
    void shouldPay() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertTrue(savingAcc.pay(50));
    }

    @Test
    void shouldPayAndCountNewBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        savingAcc.pay(100);

        Assertions.assertEquals(900, savingAcc.getBalance());
    }

    @Test
    void shouldPayIfNewBalanceEvenMinBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertTrue(savingAcc.pay(1000));
    }

    @Test
    void shouldPayIfNewBalanceMoreMinBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertTrue(savingAcc.pay(999));
    }

    @Test
    void shouldNotPayIfAmountIsNegative() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertFalse(savingAcc.pay(-50));
    }

    @Test
    void shouldNotPayIfNewBalanceIsLessThanMinBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertFalse(savingAcc.pay(1500));
    }

    /**
     * Тестируенм медод add
     */
    @Test
    void ShouldAddAmount() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertTrue(savingAcc.add(999));
    }

    @Test
    void ShouldAddAmountAndCountNewBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        savingAcc.add(999);

        Assertions.assertEquals(1999, savingAcc.getBalance());
    }

    @Test
    void ShouldNotAddAmountIfZero() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertFalse(savingAcc.add(0));
    }

    @Test
    void ShouldNotAddAmountIfNegative() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertFalse(savingAcc.add(-10));
    }

    @Test
    void ShouldNotAddAmountIfOverMaxBalance() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        Assertions.assertFalse(savingAcc.add(50_000));
    }

    /**
     * Тестируенм медод yearChange
     */
    @Test
    void ShouldCalculateYearChange() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                5
        );

        int expected = 50;
        int actual = savingAcc.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateYearChangeIfBalanceZero() {
        SavingAccount savingAcc = new SavingAccount(
                0,
                0,
                50_000,
                5
        );

        int expected = 0;
        int actual = savingAcc.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateYearChangeIfRateZero() {
        SavingAccount savingAcc = new SavingAccount(
                1000,
                0,
                50_000,
                0
        );

        int expected = 0;
        int actual = savingAcc.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void ShouldCalculateYearChangeIfAnswerNeedToRoundUp() {
        SavingAccount savingAcc = new SavingAccount(
                1111,
                0,
                50_000,
                3
        );

        int expected = 33;
        int actual = savingAcc.yearChange();

        Assertions.assertEquals(expected, actual);
    }

}

