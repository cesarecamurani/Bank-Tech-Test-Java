package bank;

class BankAccount{

    private int balance;
    private Transaction transaction;
    private void noCredit(int amount){
        if(amount > this.balance){
            throw new Error ("Not enough credit!");
        }
    }

    BankAccount(int balance, Transaction transaction){
        this.balance = balance;
        this.transaction = transaction;
    }

    int viewBalance(){
        return this.balance;
    }

    void deposit(int amount) {
        this.balance += amount;
        this.transaction.credit(amount, this.balance);
    }

    void withdraw(int amount){
        noCredit(amount);
        this.balance -= amount;
        this.transaction.debit(amount, this.balance);
    }
}