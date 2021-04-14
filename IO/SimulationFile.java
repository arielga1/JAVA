/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package IO;

import Country.*;
import Location.*;
import Population.Healthy;
import Population.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimulationFile {
    private String path;

    public SimulationFile(String filePath) { this.path = filePath; }

    /**
     * Converts a line from the file into a settlement object.
     * @param line          The line.
     * @return              A settlement object.
     */
    private Settlement parseLine(String line) {
        StringTokenizer stok = new StringTokenizer(line, "; ");
        // Format is "Type; Name; X;Y; SX;SY; Capacity"
        // X and Y are the coordinates of the upper-left corner of the
        // settlement.
        // SX and SY are the x and y sizes of the settlement
        // Capacity is the population capacity.
        String type = stok.nextToken();
        String name = stok.nextToken();
        int px = Integer.parseInt(stok.nextToken());
        int py = Integer.parseInt(stok.nextToken());
        int sx = Integer.parseInt(stok.nextToken());
        int sy = Integer.parseInt(stok.nextToken());
        int capacity = Integer.parseInt(stok.nextToken());
        Location l = new Location(new Point(px, py), new Size(sx, sy));
        ArrayList<Person> pop = new ArrayList<>();
        switch(type) {
            case "City":
                return new City(name, l, pop, capacity);
            case "Kibbutz":
                return new Kibbutz(name, l, pop, capacity);
            case "Moshav":
                return new Moshav(name, l, pop, capacity);
            default:
                throw new RuntimeException("Invalid settlement type.");
        }
    }

    /**
     * Fills a settlement with people.
     * @param set           The settlement.
     */
    private void fillSettlement(Settlement set) {
        for (int i = 0 ; i < set.getCapacity() ; ++i ) {
            int age = this.randomAge(9, 6, 4);
            Point p = set.randomLocation();
            set.addPerson(new Healthy(age, p, set));
        }
    }

    /**
     * Generates a random age.
     *
     * Follows the following formula: 5*x+y
     *
     * @param mean              The mean value.
     * @param deviation         The deviation.
     * @param yBound            The upper limit for the y.
     * @return                  The age.
     */
    private int randomAge(int mean, int deviation, int yBound) {
        Random rnd = new Random();
        int y = rnd.nextInt(yBound + 1);
        double d;
        do {
            d = rnd.nextGaussian();
        } while (d > 1 || d < -1);
        int x = (int)(d * deviation + mean);
        return 5 * x + y;
    }

    /**
     * Reads a list of settlements from a file and returns them.
     * @return                  the list of settlements.
     */
    public Map readSettlements() {
        File f = new File(this.path);
        try {
            Scanner reader = new Scanner(f);
            ArrayList<Settlement> sets = new ArrayList<>();
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                Settlement set = this.parseLine(data);
                this.fillSettlement(set);
                sets.add(set);
            }
            return new Map(sets);
        }
        catch (FileNotFoundException e) {
            System.err.println("Was unable to open the file.");
            return null;
        }
    }

    public static void main(String [] args) {
        SimulationFile sf = new SimulationFile("data/settlements.txt");
        Map sets = sf.readSettlements();
        System.out.println(sets);
    }
}
