package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    private static int globalNumber = 0;

    private final int number;
    private final BigDecimal amount;
    private final Date date;

    public Transaction(BigDecimal amount) {
        this.number = ++globalNumber;
        this.amount = amount;
        this.date = new Date();
    }

    @Override
    public String toString() {
        String name;
        if (amount.compareTo(BigDecimal.ZERO) > 0) {
            name = "Пополнение";
        } else {
            name = "Снятие";
        }
        return number + ". " + name + ": " + amount + " руб " + "(" + formatter.format(date) + ")";
    }
}
