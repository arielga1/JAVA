package Country;

import java.util.List;
import Location.Location;
import Population.Person;

public class Moshav extends Settlement{
	/**
	 * Constructor for a moshav.
	 *
	 * {@inheritDoc}
	 */
	public Moshav(String name, Location location,
				  List<Person> people, int capacity) {
		super(name, location, people, capacity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected double getRamzorCoefficient(RamzorColor c) {
		double p = this.contagiousPercent();
		double cv = c.coefficient();
		return 0.3 + 3 * Math.pow(
				Math.pow(1.2, cv) * (p - 0.35),
				5
		);
	}
}