package display;

import model.Account;
import model.InMemorySingletonAccount;
import repository.InMemoryAccountRepository;
import service.AccountService;
import service.DefaultAccountService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Optional;

public class ConsoleActionDispatcher implements ActionDispatcher {

    private final AccountService accountService;

    //создание единичного экземпляра аккаунта
    private final Account account = InMemorySingletonAccount.getInstance();

    public ConsoleActionDispatcher() {
        this.accountService = new DefaultAccountService(new InMemoryAccountRepository());
    }

    @Override
    public void dispatch(int actionIndex) {
        switch (actionIndex) {
            case 1 -> {
                System.out.println("Введите сумму для пополнения: ");
                inputValueFromConsole().ifPresent(optionalValue ->
                    accountService.depositRequest(account, optionalValue));
            }
            case 2 -> {
                System.out.println("Введите сумму для снятия: ");
                inputValueFromConsole().ifPresent(optionalValue ->
                    accountService.withdrawRequest(account, optionalValue));
            }
            case 3 -> accountService.getBalance(account);
            case 4 -> accountService.getTransactions(account);
            case 5 -> {
                System.out.println("До свидания!");
                ConsoleMenuAppStarter.stop();
            }
            default -> System.out.println("Ошибка ввода. Введите число, соответствующее действию.\n");
        }
    }

    private Optional<BigDecimal> inputValueFromConsole() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Optional<BigDecimal> optionalValue = Optional.empty();
        try {
            optionalValue = Optional.of(new BigDecimal(reader.readLine()));
        } catch (NumberFormatException | IOException e) {
            System.out.println("Ошибка ввода. Введите число.\n");
        }
        return optionalValue;
    }

}
