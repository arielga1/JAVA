/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Healthy))
            return false;
        return super.equals(other);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Healthy Person\n" +
                super.toString();
    }
}
