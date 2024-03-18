package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleMenuAppStarter implements AppStarter {

    private static boolean isRunning;
    private final ActionDispatcher actionDispatcher;

    public ConsoleMenuAppStarter() {
        isRunning = true;
        actionDispatcher = new ConsoleActionDispatcher();
    }

    @Override
    public void start() {

        System.out.println("Добро пожаловать в приложение \"Банковский счет\"!");

        System.out.println("1. Пополнить счет");
        System.out.println("2. Снять деньги");
        System.out.println("3. Проверить баланс");
        System.out.println("4. История транзакций");
        System.out.println("5. Выход");

        while (isRunning) {

            System.out.print("Выберите действие (введите номер): ");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                actionDispatcher.dispatch(Integer.parseInt(reader.readLine()));
            } catch (NumberFormatException | IOException e) {
                System.out.println("Ошибка ввода. Введите число, соответствующее действию.\n");
            }

        }

    }

    protected static void stop() {
        isRunning = false;
    }

}
