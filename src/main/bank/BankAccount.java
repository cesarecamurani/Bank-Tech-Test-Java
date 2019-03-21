package bank;

import java.util.Date;

class BankAccount{

    private double balance;
    private double limit = 2500.00;
    private Transaction transaction;

    BankAccount(double balance, Transaction transaction){
        this.balance = balance;
        this.transaction = transaction;
    }

    double viewBalance(){
        return this.balance;
    }

    void deposit(double amount) {
        this.balance += amount;
        this.transaction.credit(new Date(), amount, this.balance);
    }

    void withdraw(double amount){
        noCredit(amount);
        checkLimit(amount);
        this.balance -= amount;
        this.transaction.debit(new Date(), amount, this.balance);
    }

    private void noCredit(double amount){
        if(amount > this.balance){
            throw new Error ("Not enough credit!");
        }
    }

    private void checkLimit(double amount){
        if(amount > limit){
            throw new Error ("You reached your daily limit!");
        }
    }

    String printStatement(){
        return this.transaction.displayStatement();
    }
}