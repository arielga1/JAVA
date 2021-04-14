package Population;

import Virus.IVirus;

public class Convalescent extends Person{
    private IVirus virus;

    /**
     * Constructor.
     * @param person        The formerly ill person.
     * @param virus         The virus he had.
     */
    public Convalescent(Person person, IVirus virus) {
        super(person);
        this.virus = virus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double contagionProbability() { return 0.2; }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Convalescent))
            return false;
        return super.equals(other) && virus.equals(((Convalescent) other).virus);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Convalescent Person\n" +
                "Had Virus: " + this.virus + "\n" +
                super.toString();
    }
}
