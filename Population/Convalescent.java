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

    @Override
    public double contagionProbability() { return 0.2; }
}
