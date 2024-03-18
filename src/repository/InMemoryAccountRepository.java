package repository;

import model.Account;
import model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    private final Account account = new Account();

    @Override
    public void updateBalance(BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        account.getTransactions().add(new Transaction(amount));
    }

    @Override
    public BigDecimal getBalance() {
        return account.getBalance();
    }

    @Override
    public List<Transaction> getTransactions() {
        return account.getTransactions();
    }

}
