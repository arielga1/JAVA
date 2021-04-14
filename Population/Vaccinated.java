/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Population;

import Location.Point;

public class Vaccinated extends Person {
    private long vaccinationTime;
    private static long limit = 21;

    /**
     * Constructor.
     * @param person          A person either after vaccination or a virus.
     */
    public Vaccinated(Person person) {
        super(person);
        this.vaccinationTime = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double contagionProbability() {
        if (this.vaccinationTime < limit) {
            // min(1, 0.56+0.15*sqrt(21-t))  :  t<21
            return Math.min(1, 0.56 + 0.15 * Math.sqrt(limit - this.vaccinationTime));
        } else {
            // max(0.05, 1.05/(t-14))        :  t>=21
            return Math.max(0.05, 1.05/(this.vaccinationTime - 14));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Vaccinated))
            return false;
        return super.equals(other) &&
                (this.vaccinationTime == ((Vaccinated) other).vaccinationTime);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Vaccinated Person\n" +
                "Vaccinated for: " + this.vaccinationTime + "\n" +
                super.toString();
    }

    public static void main(String [] args) {
        Vaccinated p = (Vaccinated) (new Healthy(1, new Point(0, 0), null)).vaccinate();
        double d = p.contagionProbability();
    }
}
