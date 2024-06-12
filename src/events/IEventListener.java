/**
 * Functional Interface heeft één abstracte methode waardoor deze makkelijk aangeroepen kan worden met een lambda.
 * Elke "subscriber" MOET 'invoke()' bevatten.
 */
package events;

@FunctionalInterface
public interface IEventListener {

    void invoke(Object sender, EventArgs args);
}
