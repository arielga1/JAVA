package Country;

import Location.*;
import Population.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Settlement {
    private String name;
    private Location location;
    private List<Person> people;
    private RamzorColor ramzorColor;

    /**
     * The constructor.
     * @param name          The name of the settlement.
     * @param location      The location of the settlement.
     * @param people        The people living in the settlement.
     */
    public Settlement(String name, Location location,
                      List<Person> people) {
                        this.name = name;
                        this.location = location;
                        if (people == null) {
                            this.people = new ArrayList<>();
                        }
                        this.people = people;
                        this.ramzorColor = RamzorColor.Green;
    }

    /**
     * Calculates the ramzor grade of the city.
     * @return              The grade.
     */
    public abstract RamzorColor calculateRamzorGrade();

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Settlement))
            return false;
        Settlement set = (Settlement)other;
        return this.name.equals(set.name) &&
                this.location.equals(set.location) &&
                this.people.equals(set.people) &&
                this.ramzorColor.equals(set.ramzorColor);
    }
}
