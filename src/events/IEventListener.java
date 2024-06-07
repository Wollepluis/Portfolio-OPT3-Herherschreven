package events;

@FunctionalInterface
public interface IEventListener {

    void invoke(Object sender, EventArgs args);
}
