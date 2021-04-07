package Population;

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
}
