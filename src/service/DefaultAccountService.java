package service;

import model.Account;
import repository.AccountRepository;

import java.math.BigDecimal;

public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void depositRequest(Account account, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            accountRepository.updateBalance(account, amount);
            System.out.println("Счет успешно пополнен на " + amount + " руб.\n");
        } else {
            System.out.println("Сумма должна быть больше 0\n");
        }
    }

    @Override
    public void withdrawRequest(Account account, BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            if (amount.compareTo(accountRepository.getBalance(account)) <= 0) {
                accountRepository.updateBalance(account, amount.negate());
                System.out.println("Со счета снято " + amount + " руб.\n");
            } else {
                System.out.println("Недостаточно средств на счету (" + accountRepository.getBalance(account) + " руб.)\n");
            }
        } else {
            System.out.println("Сумма должна быть больше 0\n");
        }
    }

    @Override
    public void getBalance(Account account) {
        System.out.println("Баланс на счете: " + accountRepository.getBalance(account) + " руб.\n");
    }

    @Override
    public void getTransactions(Account account) {
        System.out.println("История транзакций:");
        if (accountRepository.getTransactions(account).isEmpty()) {
            System.out.println("История транзакций пуста");
        } else {
            accountRepository.getTransactions(account).forEach(System.out::println);
        }
        System.out.println();
    }

}
