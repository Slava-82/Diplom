package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {


    @Test
public void testAmountTrue() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                0, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                0, 0, 10000, 15
        );

        Assertions.assertTrue(bank.transfer(creditAccount, savingAccount, 100));
}

    @Test
    public void testAmountFalse() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                0, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                0, 0, 10000, 15
        );

        Assertions.assertFalse(bank.transfer(creditAccount, savingAccount, -1000));
    }

    @Test
    public void testTransferFromCreditAccountToSavingAccountIfInitialBalanceZero() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                0, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                0, 0, 10000, 15
        );

        bank.transfer(creditAccount,savingAccount,1000);

        Assertions.assertEquals(1000, savingAccount.getBalance());
    }

    @Test
    public void testTransferFromCreditAccountToSavingAccountIfInitialBalance1() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                0, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                1, 0, 10000, 15
        );

        bank.transfer(creditAccount,savingAccount,1000);

        Assertions.assertEquals(1001, savingAccount.getBalance());
    }

    @Test
    public void testTransferFromCreditAccountIfInitialBalance500ToSavingAccountIfInitialBalance1() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                500, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                1, 0, 10000, 15
        );

        bank.transfer(creditAccount,savingAccount,500);

        Assertions.assertEquals(0, creditAccount.getBalance());
    }

    @Test
    public void testTransfer() {
        Bank bank = new Bank();
        CreditAccount creditAccount = new CreditAccount(
                1, 5000, 15
        );
        CreditAccount creditAccount1 = new CreditAccount(
                0, 5000, 15
        );
        CreditAccount creditAccount2 = new CreditAccount(
                0, 5000, 15
        );
        SavingAccount savingAccount = new SavingAccount(
                0, 0, 10000, 15
        );
        SavingAccount savingAccount1 = new SavingAccount(
                0, 0, 10000, 15
        );

        bank.transfer(creditAccount,creditAccount1,1);
        bank.transfer(creditAccount1,creditAccount2,1);
        bank.transfer(creditAccount2,savingAccount,1);
        bank.transfer(savingAccount,savingAccount1,1);

        System.out.println(creditAccount.getBalance());
        System.out.println(creditAccount1.getBalance());
        System.out.println(creditAccount2.getBalance());
        System.out.println(savingAccount.getBalance());
        System.out.println(savingAccount1.getBalance());

        Assertions.assertEquals(1, savingAccount1.getBalance());
    }

    @Test
    public void test() {
        Bank bank = new Bank();

        SavingAccount savingAccount = new SavingAccount(
                1000, 0, 10000, 15
        );
        CreditAccount creditAccount = new CreditAccount(
                0, 5000, 15
        );

        creditAccount.pay(100);
        savingAccount.yearChange();
        creditAccount.add(savingAccount.yearChange());

        bank.transfer(creditAccount,savingAccount, creditAccount.getBalance());

        Assertions.assertEquals(1050, savingAccount.getBalance());
    }
}


