package Country;

import Location.*;
import Population.Healthy;
import Population.Person;

import java.util.ArrayList;

public class CountryDriver {

    public static void main(String [] args) {
        String name = "Nowhere";
        Location l = new Location(new Point(0,0), new Size(50, 50));
        Settlement city = new City(name, l, new ArrayList<>(), 1000);
        Settlement kib = new Kibbutz(name, l, new ArrayList<>(), 1000);
        Settlement mos = new Moshav(name, l, new ArrayList<>(), 1000);

        Person p1 = new Healthy(20, city.randomLocation(), city);
        System.out.println(city.addPerson(p1));

        Person p2 = new Healthy(20, kib.randomLocation(), kib);
        System.out.println(kib.addPerson(p1));

        Person p3 = new Healthy(20, mos.randomLocation(), mos);
        System.out.println(mos.addPerson(p1));
    }
}
