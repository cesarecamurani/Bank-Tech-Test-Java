package bank;

import org.junit.*;
import java.util.Hashtable;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransactionTest{

    private Transaction transaction;
    private Hashtable<String, Integer> transactions;

    @Before
    public void setup(){
        transactions = new Hashtable<>();
        transaction = new Transaction(transactions);
    }

    @Test
    public void creditShouldAddCreditToStatement() {
        transaction.credit(1000, 2000);
        assertTrue(transactions.get("credit").equals(1000));
        assertTrue(transactions.get("balance").equals(2000));
    }
}