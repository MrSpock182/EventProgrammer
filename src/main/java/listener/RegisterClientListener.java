package listener;

import callback.Callback;
import orm.Client;
import orm.Event;
import orm.builder.ResponseBuilder;
import repository.Repository;

public class RegisterClientListener implements EventListener<Client> {

    @Override
    public void onReceiver(Event<Client> event) {
        Repository repository = Repository.getInstance();
        Client client = event.getPayload();

        Callback callback;
        if (client.getId() % 2 != 0) {
            callback = event.getOnFailure();
            callback.callback(ResponseBuilder.builder()
                    .message("Invalid queue client")
                    .build());
        } else {
            repository.insertClient(client);
            callback = event.getOnSuccess();
            callback.callback(ResponseBuilder.builder()
                    .message("Success register")
                    .build());
        }
    }
}
