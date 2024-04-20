package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankTest {
    //credit - credit
    @Test
    void noTransferIfAmountIsNegative() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        CreditAccount credit2 = new CreditAccount(3_000, 5_000, 30);

        Assertions.assertFalse(bank.transfer(credit, credit2, -1_000));
    }

    @Test
    void TransferCrToCrIfNewBalanceNotCrossCreditLimit() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        CreditAccount credit2 = new CreditAccount(3_000, 5_000, 30);

        Assertions.assertTrue(bank.transfer(credit, credit2, 3_000));
    }

    @Test
    void TransferCrToCrIfNewBalanceEvenCreditLimit() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        CreditAccount credit2 = new CreditAccount(3_000, 5_000, 30);

        Assertions.assertTrue(bank.transfer(credit, credit2, 6000));
    }

    @Test
    void NoTransferCrToCrIfNewBalanceNotSufficient() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        CreditAccount credit2 = new CreditAccount(3_000, 5_000, 30);

        Assertions.assertFalse(bank.transfer(credit, credit2, 70_000));
    }

    // credit - saving
    @Test
    void TransferCrToSavIfNewBalanceNotCrossCreditLimitAndNotCrossMaxBalance() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        SavingAccount saving = new SavingAccount(1_000, 100, 10_000, 5);

        Assertions.assertTrue(bank.transfer(credit, saving, 3_000));
    }

    @Test
    void NoTransferCrToSavIfNewBalanceNotCrossCreditLimitAndEvenMaxBalance() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        SavingAccount saving = new SavingAccount(1_000, 100, 2_000, 5);

        Assertions.assertTrue(bank.transfer(credit, saving, 1_000));
    }

    @Test
    void NoTransferCrToSavIfNewBalanceNotCrossCreditLimitAndCrossMaxBalance() {
        Bank bank = new Bank();
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);
        SavingAccount saving = new SavingAccount(1_000, 100, 2_000, 5);

        Assertions.assertFalse(bank.transfer(credit, saving, 3_000));
    }

    // saving - saving
    @Test
    void TransferSavToSavIfNewBalanceNotCrossMinBalanceAndNotCrossMaxBalance() {
        Bank bank = new Bank();
        SavingAccount saving = new SavingAccount(1_000, 100, 10_000, 5);
        SavingAccount saving2 = new SavingAccount(1_000, 100, 10_000, 5);

        Assertions.assertTrue(bank.transfer(saving, saving2, 300));
    }

    @Test
    void TransferSavToSavIfNewBalanceEvenMinBalanceAndEvenMaxBalance() {
        Bank bank = new Bank();
        SavingAccount saving = new SavingAccount(1_000, 0, 10_000, 5);
        SavingAccount saving2 = new SavingAccount(1_000, 100, 2_000, 5);

        Assertions.assertTrue(bank.transfer(saving, saving2, 1_000));
    }

    @Test
    void NoTransferSavToSavIfNewBalanceLessMinBalance() {
        Bank bank = new Bank();
        SavingAccount saving = new SavingAccount(1_000, 100, 10_000, 5);
        SavingAccount saving2 = new SavingAccount(1_000, 100, 10_000, 5);

        Assertions.assertFalse(bank.transfer(saving, saving2, 3_000));
    }

    @Test
    void NoTransferSavToSavIfNewBalanceNotCrossMinBalanceNewBalanceOverMaxBalance() {
        Bank bank = new Bank();
        SavingAccount saving = new SavingAccount(10_000, 100, 20_000, 5);
        SavingAccount saving2 = new SavingAccount(1_000, 100, 2_000, 5);

        Assertions.assertFalse(bank.transfer(saving, saving2, 3_000));
    }

    //saving - credit
    @Test
    void TransferSavToCrIfNewBalanceNotCrossMinBalance() {
        Bank bank = new Bank();
        SavingAccount saving = new SavingAccount(1_000, 100, 10_000, 5);
        CreditAccount credit = new CreditAccount(1_000, 5_000, 30);

        Assertions.assertTrue(bank.transfer(saving, credit, 300));
    }

}