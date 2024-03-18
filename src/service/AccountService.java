package service;

import java.math.BigDecimal;

public interface AccountService {

    void depositRequest(BigDecimal amount);

    void withdrawRequest(BigDecimal amount);

    void getBalance();

    void getTransactions();
}
