package service;

import listener.EventListener;
import orm.Client;
import orm.Event;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventEngine {
    private static final Queue<Event<Client>> eventQueue = new LinkedBlockingQueue<>();
    private static final Map<String, EventListener<Client>> eventListener = new HashMap<>();

    private EventEngine() {}

    public static void subscribeListener(String type, EventListener<Client> listener) {
        eventListener.put(type, listener);
    }

    public static void publish(Event<Client> event) {
        eventQueue.add(event);
    }

    public static void start() {
        new Thread(() -> {
            while (true) {
                Event<Client> event = eventQueue.poll();

                if (event != null) {
                    EventListener<Client> listener = eventListener.get(event.getType());
                    if (listener != null) {
                        listener.onReceiver(event);
                    }
                }

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }


}
