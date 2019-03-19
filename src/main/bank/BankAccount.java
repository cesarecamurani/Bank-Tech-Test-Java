package bank;

import java.util.List;
import java.util.Map;

class BankAccount{

    private Integer balance;
    private Transaction transaction;
    private void noCredit(Integer amount){
        if(amount > this.balance){
            throw new Error ("Not enough credit!");
        }
    }

    BankAccount(Integer balance, Transaction transaction){
        this.balance = balance;
        this.transaction = transaction;
    }

    int viewBalance(){
        return this.balance;
    }

    void deposit(Integer amount) {
        this.balance += amount;
//        this.transaction.credit(amount, this.balance);
    }

    void withdraw(Integer amount){
        noCredit(amount);
        this.balance -= amount;
//        this.transaction.debit(amount, this.balance);
    }
}