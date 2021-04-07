package Virus;

import Population.Person;

/**
 * The Varus TM
 *
 * https://www.youtube.com/watch?v=2rRIqrWuYy4
 *
 * https://www.youtube.com/watch?v=P1FUMdHU29c
 */
public interface IVirus {
    /**
     * Checks the likelihood of infecting the given person.
     * @param person        The person being tested.
     * @return              The result.
     */
    double contagionProbability(Person person);

    /**
     * Attempts to have person 1 infect person 2.
     * @param person1       The infected person.
     * @param person2       The person to be infected.
     * @return              The result.
     */
    boolean tryToContagion(Person person1, Person person2);

    /**
     * Attempts to kill a person.
     * @param person        The person.
     * @return              The result.
     */
    boolean tryToKill(Person person);
}
