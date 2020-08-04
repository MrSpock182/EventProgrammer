package listener;

import orm.Event;

public interface EventListener<T> {
    void onReceiver(Event<T> event);
}
