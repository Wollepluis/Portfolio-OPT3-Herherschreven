package events;

import java.util.ArrayList;

public class EventHandler {

    private final ArrayList<IEventListener> listeners = new ArrayList<>();

    public void subscribe(IEventListener listener) {

        if (!contains(listener)) {
            listeners.add(listener);
        }
    }

    public void unsubscribe(IEventListener listener) {

        if (contains(listener)) {
            listeners.remove(listener);
        }
    }

    public boolean contains(IEventListener listener) {
        return listeners.contains(listener);
    }

    public void invoke(Object sender, EventArgs args) {

        for (IEventListener listener : listeners) {
            listener.invoke(sender, args);
        }
    }
}
