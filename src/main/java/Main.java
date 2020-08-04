import listener.RegisterClientListener;
import orm.Client;
import orm.Event;
import service.EventEngine;

import java.util.UUID;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    static {
        EventEngine.start();
        EventEngine.subscribeListener("CLIENT_REGISTRATION", new RegisterClientListener());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Client client = new Client(i, UUID.randomUUID());

            Event<Client> event = new Event<>("CLIENT_REGISTRATION", client,
                    payload -> logger.info("Success callback: " + payload.getMessage()),
                    payload -> logger.info("Failure callback: " + payload.getMessage()));

            EventEngine.publish(event);
        }
    }

}
