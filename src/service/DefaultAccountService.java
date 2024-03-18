package service;

import repository.AccountRepository;

import java.math.BigDecimal;

public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void depositRequest(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            accountRepository.updateBalance(amount);
            System.out.println("Счет успешно пополнен на " + amount + " руб.\n");
        } else {
            System.out.println("Сумма должна быть больше 0\n");
        }
    }

    @Override
    public void withdrawRequest(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            if (amount.compareTo(accountRepository.getBalance()) <= 0) {
                accountRepository.updateBalance(amount.negate());
                System.out.println("Со счета снято " + amount + " руб.\n");
            } else {
                System.out.println("Недостаточно средств на счету (" + accountRepository.getBalance() + " руб.)\n");
            }
        } else {
            System.out.println("Сумма должна быть больше 0\n");
        }
    }

    @Override
    public void getBalance() {
        System.out.println("Баланс на счете: " + accountRepository.getBalance() + " руб.\n");
    }

    @Override
    public void getTransactions() {
        System.out.println("История транзакций:");
        accountRepository.getTransactions().forEach(System.out::println);
        if (accountRepository.getTransactions().isEmpty()) {
            System.out.println("История транзакций пуста");
        }
        System.out.println();
    }

}
