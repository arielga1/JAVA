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

    @Override
    public boolean getHealthStatus() {
        return false;
    }

    @Override
    public Person contagion(IVirus virus) {
        throw new RuntimeException("A sick person cannot be infected.");
    }

    /**
     * Getter for contagion time.
     * @return              The time the person had the virus.
     */
    public long getContagionTime() { return this.contagionTime; }
}
