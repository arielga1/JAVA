/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Country;

import java.util.List;
import Location.Location;
import Population.Person;

public class Kibbutz extends Settlement{
	/**
	 * Constructor for a kibbutz.
	 *
	 * {@inheritDoc}
	 */
	public Kibbutz(String name, Location location,
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
		return 0.45 + Math.pow(
				Math.pow(1.5, cv) * (p - 0.4),
				3
		);
	}
}

