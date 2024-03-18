package model;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public abstract class Account {

    public BigDecimal balance = BigDecimal.ZERO;
    public final List<Transaction> transactions = new LinkedList<>();

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

}
