package bank;

import java.util.*;
import java.time.*;
import java.time.format.*;

interface DateTime {
    Date getDate();
}

class DateTimeImpl implements DateTime {
    @Override
    public Date getDate() {
        return new Date();
    }
}

class Transaction{

    DateTime dateTime;
    private TreeMap transactions;
    private ZonedDateTime rawDate = ZonedDateTime.now();
    private String date = DateTimeFormatter.ofPattern("dd/MM/YYYY").format(rawDate);

    Transaction(TreeMap transactions, DateTime dateTime){
        this.transactions = transactions;
        this.dateTime = dateTime;
    }

    void credit(Integer amount, Integer balance){
        this.transactions.put("date", this.dateTime.getDate().toString());
        this.transactions.put("credit", amount.toString());
        this.transactions.put("debit", "0");
        this.transactions.put("balance", balance.toString());
    }

    void debit(Integer amount, Integer balance){
        this.transactions.put("date", date);
        this.transactions.put("credit", "0");
        this.transactions.put("debit", amount.toString());
        this.transactions.put("balance", balance.toString());
    }
}