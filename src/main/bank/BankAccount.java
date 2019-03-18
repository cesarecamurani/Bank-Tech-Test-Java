package bank;

public class BankAccount{

    private int balance;
    private void noCredit(int amount){
        if(amount > this.balance){
            throw new Error("Not enough credit!");
        }
    }

    BankAccount(int balance){
        this.balance = balance;
    }

    int viewBalance(){
        return this.balance;
    }

    void deposit(int amount){
        this.balance += amount;
    }

    void withdraw(int amount){
        noCredit(amount);
        this.balance -= amount;
    }
}