/**
 * Dient als basis voor de gebeurtenis argumenten.
 *
 * 'Empty' initialiseert een nieuwe instantie van 'EventArgs'.
 * 'isEmpty()' controleert of de meegegeven argumenten gelijk zijn aan deze instantie.
 */
package events;

public class EventArgs {

    public static EventArgs Empty = new EventArgs();

    public boolean isEmpty(EventArgs args) {
        return args.equals(Empty);
    }
}
