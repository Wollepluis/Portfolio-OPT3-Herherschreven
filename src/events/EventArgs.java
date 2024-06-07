package events;

public class EventArgs {

    public static EventArgs Empty = new EventArgs();

    public boolean isEmpty(EventArgs args) {
        return args.equals(Empty);
    }
}
