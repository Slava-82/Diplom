package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(3000, account.getBalance());
    }
    @Test
    public void shouldAddToPositiveBalanceIfInitialBalance1000() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3000);
        Assertions.assertEquals(4_000, account.getBalance());
    }
    @Test
    public void testAddAmountMinus() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-1000);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void testAddAmountZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(0);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldPayToNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(3000);
        Assertions.assertEquals(-3_000, account.getBalance());
    }
    @Test
    public void shouldPayToNegativeBalanceIfInitialBalance1000() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.pay(3000);
        Assertions.assertEquals(-2_000, account.getBalance());
    }
    @Test
    public void shouldPayToNegativeBalanceLowerCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(6000);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void testPayAmountMinus() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-1000);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void testPayAmountZero() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(0);
        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void testYearChangeNegativeBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );
        account.pay(400);
        account.yearChange();

        Assertions.assertEquals(-30, account.yearChange());
    }
    @Test
    public void testYearChangePositiveBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();
        Assertions.assertEquals(0, account.yearChange());
    }
    @Test
    public void testCreditAccountCreditLimitNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(1000, -5000, 15);
                });
    }
    @Test
    public void testCreditAccountInitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(-1000, 5000, 15);
                });
    }
    @Test
    public void testCreditAccountRateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new CreditAccount(1000, 5000, -15);
                });
    }
    @Test
    void shouldPayAmountTrue() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(50));
    }
    @Test
    void shouldPayAmountFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(-50));
    }
    @Test
    void shouldPayAmountZero() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(0));
    }
    @Test
    void shouldPayBalanceMoreCreditLimitTrue() {
        CreditAccount account = new CreditAccount(
                10_000,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(50));
    }
    @Test
    void shouldPayBalanceNegativeCreditLimitFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(50_000));
    }
    @Test
    void shouldPayBalanceEqualsCreditLimitTrue() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertTrue(account.pay(5_000));
    }
    @Test
    void shouldAddAmountTrue() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertTrue(account.add(500));
    }
    @Test
    void shouldAddAmountFalse() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertFalse(account.pay(-500));
    }
    @Test
    void shouldAddTrue() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        Assertions.assertTrue(account.add(1000));
    }
}