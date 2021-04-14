/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Population;

import Virus.IVirus;

public class Sick extends Person {
    private long contagionTime;
    private IVirus virus;

    /**
     * A copy constructor.
     * @param person        The base person.
     * @param virus         The virus.
     */
    public Sick(Person person, IVirus virus) {
        super(person);
        this.virus = virus;
        this.contagionTime = 0;
    }

    /**
     * Attempts to recover from the virus.
     * @return              The person as a healthy person.
     */
    public Person recover() { return new Vaccinated(this); }

    /**
     * Tries to die.
     * @return              True if dead, false otherwise.
     */
    public boolean tryToDie() { return this.virus.tryToKill(this); }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getHealthStatus() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double contagionProbability() { return 0; }

    /**
     * {@inheritDoc}
     * Returns a null, since he is already sick with a virus.
     */
    @Override
    public Sick contagion(IVirus virus) {
        return null;
    }

    /**
     * Getter for contagion time.
     * @return              The time the person had the virus.
     */
    public long getContagionTime() { return this.contagionTime; }

    /**
     * Makes the sick person come in contact with someone else.
     * @param other         The other person.
     * @return              Whether or not the other person got infected.
     */
    public boolean touch(Person other) {
        boolean res = this.virus.tryToContagion(this, other);
        if (res)
            other.contagion(this.virus);
        return res;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Sick))
            return false;
        return super.equals(other) &&
                (this.contagionTime == ((Sick) other).contagionTime) &&
                this.virus.equals(((Sick) other).virus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Sick Person\n" +
                this.virus + "\n" +
                "Sick for: " + this.contagionTime + "\n" +
                super.toString();
    }
}
