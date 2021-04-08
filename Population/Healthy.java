package Population;

import Country.Settlement;
import Location.Point;

public class Healthy extends Person {
    /**
     * Constructor.
     *
     * @param age           The person's age.
     * @param location      The person's location.
     * @param settlement    The settlement the person resides in.
     */
    public Healthy(int age, Point location, Settlement settlement) {
        super(age, location, settlement);
    }

    /**
     * Vaccinates the person and turns him into a vaccinated person.
     * @return              The person as a vaccinated person.
     */
    public Person vaccinate() {
        return new Vaccinated(this);
    }
}
