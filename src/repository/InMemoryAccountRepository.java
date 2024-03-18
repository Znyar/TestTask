package repository;

import model.Account;
import model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {

    @Override
    public void updateBalance(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
        account.getTransactions().add(new Transaction(amount));
    }

    @Override
    public BigDecimal getBalance(Account account) {
        return account.getBalance();
    }

    @Override
    public List<Transaction> getTransactions(Account account) {
        return account.getTransactions();
    }

}
