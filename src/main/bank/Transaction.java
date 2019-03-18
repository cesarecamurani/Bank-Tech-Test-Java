package bank;

import java.util.*;
import java.time.ZonedDateTime;

class Transaction{

    private TreeMap transactions;

    Transaction(TreeMap transactions){
        this.transactions = transactions;
    }

    void credit(Integer amount, Integer balance){
        this.transactions.put("date", ZonedDateTime.now());
        this.transactions.put("credit", amount);
        this.transactions.put("debit", null);
        this.transactions.put("balance", balance);
    }

    void debit(Integer amount, Integer balance){
        this.transactions.put("date", ZonedDateTime.now());
        this.transactions.put("credit", null);
        this.transactions.put("debit", amount);
        this.transactions.put("balance", balance);
    }
}