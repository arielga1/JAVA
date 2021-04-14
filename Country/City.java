package Country;

import java.util.List;
import Location.Location;
import Population.Person;

public class City extends Settlement {
	/**
	 * Constructor for a city.
	 *
	 * {@inheritDoc}
	 */
	public City(String name, Location location,
				List<Person> people, int capacity) {
		super(name, location, people, capacity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected double getRamzorCoefficient(RamzorColor c) {
		double p = this.contagiousPercent();
		return 0.2*(Math.pow(4,1.25*p));
	}


}
