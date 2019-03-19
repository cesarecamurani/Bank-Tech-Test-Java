package bank;

import java.util.*;

interface DateTime {
    Date getDate();
}

class Transaction{

    private DateTime dateTime;
    private Map<String,String> transactionCre = new HashMap<>();
    private Map<String,String> transactionDeb = new HashMap<>();
    private List<Map<String , String>> transactions;

    Transaction(List<Map<String , String>> transactions, DateTime dateTime){
        this.transactions = transactions;
        this.dateTime = dateTime;
    }

    void credit(Integer amount, Integer balance){
        this.transactionCre.put("date", this.dateTime.getDate().toString());
        this.transactionCre.put("credit", amount.toString());
        this.transactionCre.put("debit", "0");
        this.transactionCre.put("balance", balance.toString());
        this.transactions.add(0, transactionCre);

    }

    void debit(Integer amount, Integer balance){
        this.transactionDeb.put("date", this.dateTime.getDate().toString());
        this.transactionDeb.put("credit", "0");
        this.transactionDeb.put("debit", amount.toString());
        this.transactionDeb.put("balance", balance.toString());
        this.transactions.add(0, transactionDeb);
    }
}