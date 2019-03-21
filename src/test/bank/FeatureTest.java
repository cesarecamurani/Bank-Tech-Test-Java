package bank;

import org.junit.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FeatureTest {

        private BankAccount account;
        private Transaction transaction;
        private Statement statement;
        private ArrayList transactions = new ArrayList<>();
        private String testDate;

        @Before
        public void setup(){

            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            testDate = dateFormatter.format(new Date());
            statement = new Statement();
            transaction = new Transaction(transactions, statement);
            account = new BankAccount(0, transaction);

        }

        @Test
        public void featureTestForDepositFunctionality(){
            account.deposit(2000.00);
            account.deposit(1500.00);
            account.deposit(3000.00);
            assertEquals(testDate + " || 3000.0 || || 6500.0\n", transaction.returnTransactions().get(0));
        }

        @Test
        public void featureTestForWithdrawFunctionality(){
            account.deposit(2000.00);
            account.deposit(1500.00);
            account.deposit(3000.00);
            account.withdraw(2000.00);
            account.withdraw(500.00);
            account.withdraw(3000.00);
            assertEquals(testDate + " || || 3000.0 || 1000.0\n", transaction.returnTransactions().get(0));
        }

        @Test(expected=Error.class)
        public void featureTestForNoCreditScenario(){
            account.deposit(2000.00);
            account.deposit(1500.00);
            account.deposit(3000.00);
            account.withdraw(2000.00);
            account.withdraw(500.00);
            account.withdraw(3000.00);
            account.withdraw(3000.00);
            assertThrows(Error.class, () -> account.withdraw(3000.00));
        }

        @Test
        public void featureTestForPrintStatementFunctionality(){
            account.deposit(2000.00);
            account.deposit(1500.00);
            account.deposit(3000.00);
            account.withdraw(2000.00);
            account.withdraw(500.00);
            assertEquals(account.printStatement(), "Date || Credit || Debit || Balance\n" +
                                                         testDate + " || 2000.0 || || 2000.0\n" +
                                                         testDate + " || 1500.0 || || 3500.0\n" +
                                                         testDate + " || 3000.0 || || 6500.0\n" +
                                                         testDate + " || || 2000.0 || 4500.0\n" +
                                                         testDate + " || || 500.0 || 4000.0\n");
        }
}