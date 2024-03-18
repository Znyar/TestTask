package model;

public class InMemorySingletonAccount extends Account {

    private static InMemorySingletonAccount INSTANCE;

    private InMemorySingletonAccount() {}

    public static InMemorySingletonAccount getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InMemorySingletonAccount();
        }
        return INSTANCE;
    }

}
