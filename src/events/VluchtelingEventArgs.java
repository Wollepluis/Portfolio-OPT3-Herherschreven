/**
 * Een extensie van 'EventArgs' die het object 'Vluchteling' meegeeft als argument.
 */
package events;

import coaData.Vluchteling;

public class VluchtelingEventArgs extends EventArgs {

    private final Vluchteling vluchteling;

    public VluchtelingEventArgs(Vluchteling vluchteling) {
        this.vluchteling = vluchteling;
    }

    public Vluchteling getVluchteling() {
        return vluchteling;
    }
}
