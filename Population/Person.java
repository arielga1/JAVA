package Population;

import Country.Settlement;
import Location.Point;
import Virus.IVirus;

/**
 *
 */
public abstract class Person {
    int age;
    Point location;
    Settlement settlement;

    /**
     * Constructor.
     * @param age           The person's age.
     * @param location      The person's location.
     * @param settlement    The settlement the person resides in.
     */
    public Person(int age, Point location, Settlement settlement) {
        this.age = age;
        this.location = location;
        this.settlement = settlement;
    }

    /**
     * A copy constructor.
     * @param other         The person to copy from.
     */
    public Person(Person other) {
        this.age = other.age;
        this.location = other.location;
        this.settlement = other.settlement;
    }

    /**
     * Checks how likely the person is to catch a virus.
     * @return              The probability.
     */
    public double contagionProbability() {
        return 1;
    }

    /**
     * Passes the virus to the person and turns him into a sick person.
     * @param virus         The virus.
     * @return              The person as a sick person.
     */
    public Sick contagion(IVirus virus) {
        Sick sickMe = new Sick(this, virus);
        this.settlement.addPerson(sickMe);
        this.settlement.removePerson(this);
        return sickMe;
    }

    /**
     * Getter for age.
     * @return              The age.
     */
    public int getAge() { return this.age; }

    /**
     * Getter for location.
     * @return              The location.
     */
    public Point getLocation() { return this.location; }

    /**
     * Getter for settlement.
     * @return              The settlement.
     */
    public Settlement getSettlement() { return this.settlement; }

    /**
     * Setter for settlement.
     * @param set           The settlement to change to.
     * @return              True.
     */
    public boolean setSettlement(Settlement set) { this.settlement = set; return true; }

    /**
     * Checks the health status of the person.
     * @return              true if healthy, false if ill.
     */
    public boolean getHealthStatus() { return true; }

    /**
     * Calculates the distance between two people.
     * @param other             The other person.
     * @return                  The distance between the two.
     */
    public double distance(Person other) {
        return this.location.distance(other.location);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }
        Person p = (Person) other;
        return this.location.equals(p.location) &&
                (this.age == p.age) &&
                this.settlement == p.settlement;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.age + "; " + this.location + "; " + this.settlement.getName() + "\n";
    }
}
