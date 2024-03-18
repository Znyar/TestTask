package service;

import model.Account;

import java.math.BigDecimal;

public interface AccountService {

    void depositRequest(Account account, BigDecimal amount);

    void withdrawRequest(Account account, BigDecimal amount);

    void getBalance(Account account);

    void getTransactions(Account account);
}
