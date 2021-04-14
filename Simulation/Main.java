package Simulation;

import Country.Map;
import Country.Settlement;
import IO.SimulationFile;
import Population.Person;
import Population.Sick;
import Virus.BritishVariant;
import Virus.ChineseVariant;
import Virus.IVirus;
import Virus.SouthAfricanVariant;

public class Main {
    /**
     * Spreads viruses to some of the population of the map.
     * @param percentage            The percentage to make ill.
     * @param map                   The map.
     */
    private static void makeIll(double percentage, Map map) {
        IVirus[] vs = {new ChineseVariant(), new BritishVariant(), new SouthAfricanVariant()};
        for (int i = 0 ; i < map.size() ; ++i ) {
            IVirus v = vs[i % vs.length];
            Settlement set = map.get(i);
            int number = Math.max(1, (int)(set.numPeople() * percentage));
            spreadPlague(set, v, number);
        }
    }

    /**
     * Spreads a given virus in a given settlement to a given amount of people.
     * @param set           The settlement.
     * @param v             The virus.
     * @param number        How many people to infect.
     */
    private static void spreadPlague(Settlement set, IVirus v, int number) {
        if (number > set.numPeople())
            number = set.numPeople();
        for (int i = 0 ; i < number ; ++i ) {
            set.getPeople().get(i).contagion(v);
        }
    }

    /**
     * Runs a round of the simulation.
     * @param map           The map to simulate on.
     */
    private static void runSimulationRound(Map map) {
        for (int i = 0 ; i < map.size() ; ++i) {
            Settlement set = map.get(i);
            Sick sicko = set.getSickPerson();
            if (null == sicko)
                continue;
            for (int j = 0 ; j < 6 ; ++j) {
                Person p = set.getRandomPerson();
                sicko.touch(p);
            }
        }
    }

    public static void main(String [] args) {
        if (args.length != 2) {
            throw new RuntimeException("Wrong number of arguments.");
        }
        Clock.reset();
        String filePath = args[1];
        SimulationFile sf = new SimulationFile(filePath);
        Map map = sf.readSettlements();
        makeIll(0.01, map);
        int numLoops = 5;
        for (int  i = 0 ; i < numLoops ; ++i) {
            runSimulationRound(map);
        }
        System.out.println(map);
    }
}
