package repository;

import orm.Client;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final List<Client> list;

    private static Repository instance = null;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
        this.list = new ArrayList<>();
    }

    public void insertClient(Client client) {
        this.list.add(client);
    }

}
