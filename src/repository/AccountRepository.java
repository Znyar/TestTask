package repository;

import model.Account;
import model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

    void updateBalance(Account account, BigDecimal amount);

    BigDecimal getBalance(Account account);

    List<Transaction> getTransactions(Account account);

}
