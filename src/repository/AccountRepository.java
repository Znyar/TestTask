package repository;

import model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository {

    void updateBalance(BigDecimal amount);

    BigDecimal getBalance();

    List<Transaction> getTransactions();
}
