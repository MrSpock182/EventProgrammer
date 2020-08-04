package orm;

import java.util.UUID;

public class Client {
    private final Integer id;
    private final UUID name;

    public Client(Integer id, UUID name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "orm.Client{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
