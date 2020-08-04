package orm;

import callback.Callback;

public class Event<T> {
    private final String type;
    private final T payload;
    private final Callback onSuccess;
    private final Callback onFailure;

    public Event(String type, T payload, Callback onSuccess, Callback onFailure) {
        this.type = type;
        this.payload = payload;
        this.onSuccess = onSuccess;
        this.onFailure = onFailure;
    }

    public String getType() {
        return type;
    }

    public T getPayload() {
        return payload;
    }

    public Callback getOnSuccess() {
        return onSuccess;
    }

    public Callback getOnFailure() {
        return onFailure;
    }
}
