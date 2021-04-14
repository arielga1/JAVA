/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Virus;

import java.util.Random;

import Location.Point;
import Population.Healthy;
import Population.Person;
import Population.Sick;

public abstract class Virus implements IVirus {
    private int age1, age2;
    private double cProbability1, cProbability2, cProbability3;
    private double dieProbability1, dieProbability2, dieProbability3;

    /**
     * A constructor. Individual variants will set probabilities and age groups
     * to suit their internal logic.
     * @param age1          The separator between groups 1 and 2.
     * @param age2          The separator between groups 2 and 3.
     * @param cp1           The contagion probability of group 1.
     * @param cp2           The contagion probability of group 2.
     * @param cp3           The contagion probability of group 3.
     * @param dp1           The death probability of group 1.
     * @param dp2           The death probability of group 2.
     * @param dp3           The death probability of group 3.
     */
    public Virus(int age1, int age2,
                 double cp1, double cp2, double cp3,
                 double dp1, double dp2, double dp3) {
        this.age1 = age1;
        this.age2 = age2;
        this.cProbability1 = cp1;
        this.cProbability2 = cp2;
        this.cProbability3 = cp3;
        this.dieProbability1 = dp1;
        this.dieProbability2 = dp2;
        this.dieProbability3 = dp3;
    }

    /**
     * A constructor. Individual variants will set probabilities and age groups
     * to suit their internal logic.
     * @param age           The separator between the two groups.
     * @param cp1           The contagion probability of group 1.
     * @param cp2           The contagion probability of group 2.
     * @param dp1           The death probability of group 1.
     * @param dp2           The death probability of group 2.
     */
    public Virus(int age, double cp1, double cp2, double dp1, double dp2) {
        this.age1 = age;
        this.age2 = age;
        this.cProbability1 = cp1;
        this.cProbability2 = cp2;
        this.cProbability3 = cp2;
        this.dieProbability1 = dp1;
        this.dieProbability2 = dp2;
        this.dieProbability3 = dp2;
    }
    /**
     * Checks the likelihood of infecting the given person.
     *
     * @param person The person being tested.
     * @return The result.
     */
    @Override
    public double contagionProbability(Person person) {
        int age = person.getAge();
        if (age <= this.age1)
            return this.cProbability1 * person.contagionProbability();
        else if (age <= this.age2)
            return this.cProbability2 * person.contagionProbability();
        else
            return this.cProbability3 * person.contagionProbability();
    }

    /**
     * Attempts to have person 1 infect person 2.
     * @param person1       The infected person.
     * @param person2       The person to be infected.
     * @return              The result.
     */
    @Override
    public boolean tryToContagion(Person person1, Person person2) {
        if (person1.getHealthStatus())
            throw new RuntimeException("First argument needs to be sick.");
        if (!(person1.getSettlement().equals(person2.getSettlement())))
            throw new RuntimeException("The two people must be in the same settlement.");
        if (!person2.getHealthStatus()) {
            // get the base probability
            double probability = contagionProbability(person2);
            // apply formula
            probability = probability * Math.min(
                    1, 0.14 * Math.exp(2 - 0.25 * person1.distance(person2))
            );
            // calculate if it hit
            Random rnd = new Random();
            double chance = rnd.nextDouble();
            return chance <= probability;
        }
        return false;
    }

    /**
     * Checks the base death probability for the given age.
     * @param age           The age.
     * @return              The base probability of dying.
     */
    private double getDieProbability(int age) {
        if (age <= this.age1)
            return this.dieProbability1;
        else if (age <= this.age2)
            return this.dieProbability2;
        else
            return this.dieProbability3;
    }

    /**
     * Attempts to kill a person.
     *
     * @param person The person.
     * @return The result.
     */
    @Override
    public boolean tryToKill(Sick person) {
        // get the base chance of dying to this virus
        double probability = getDieProbability(person.getAge());
        // calculate the actual chance of the person dying.
        long time = person.getContagionTime();
        double actualProbability;
        double poi = probability - 0.01*probability*(time - 15)*(time - 15);
        actualProbability = Math.max(0, poi);
        // get a random number to see if the person died
        Random rnd = new Random();
        double chance = rnd.nextDouble();
        return chance <= actualProbability;
    }

    public static void main(String [] args) {
        Person p = new Healthy(20, new Point(2, 4), null);
        IVirus v = new ChineseVariant();
        Sick ps = p.contagion(v);
        System.out.println(v.tryToKill(ps));
    }
}
