/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Country;

import Location.*;
import Population.Person;
import Population.Sick;
import Virus.IVirus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public abstract class Settlement {
    private String name;
    private Location location;
    private List<Person> people;
    private RamzorColor ramzorColor;
    private int capacity;

    /**
     * The constructor.
     * @param name          The name of the settlement.
     * @param location      The location of the settlement.
     * @param people        The people living in the settlement.
	 * @param capacity		The capacity of the city for people.
     */
    public Settlement(String name, Location location,
                      List<Person> people, int capacity) {
    	this.name = name;
    	this.location = location;
		this.capacity = capacity;
		if (people == null) {
    		this.people = new ArrayList<>();
    	}
    	else
    		this.people = people;
    	this.ramzorColor = RamzorColor.Green;
    }

	/**
	 * Calculates the ramzor grade of the settlement.
	 * @return			The ramzor grade.
	 */
	public RamzorColor calculateRamzorGrade() {
		double c = this.getRamzorCoefficient(this.ramzorColor);
		return RamzorColor.getGrade(c);
	}

	/**
	 * Calculates the ramzor coefficient for the type of settlement.
	 * @return				The coefficient.
	 */
	protected abstract double getRamzorCoefficient(RamzorColor c);

	/**
	 * Checks what percentage of the population is sick.
	 * @return			The percentage of ill people in [0, 1].
	 */
	public double contagiousPercent() {
		int total = this.people.size();
		int count = 0;
		for (int i = 0 ; i < total ; i++) {
			if (!(this.people.get(i).getHealthStatus()))
				count++;
		}
		return count / total;
	}

	/**
	 * Generates a random point in the settlement.
	 * @return				The point.
	 */
	public Point randomLocation() {
		return this.location.randomPoint();
	}

	/**
	 * Attempts to add a person to the settlement.
	 * @param p			The person.
	 * @return			True if added, false otherwise.
	 */
	public boolean addPerson(Person p) {
		if (this.people.contains(p))
			return false;
		this.people.add(p);
		p.setSettlement(this);
		return true;
	}

	/**
	 * Removes a person from the settlement.
	 * @param p			The person.
	 * @return			The result.
	 */
	public boolean removePerson(Person p) {
		if (!this.people.contains(p))
			return false;
		this.people.remove(p);
		p.setSettlement(null);
		return true;
	}

	/**
	 * Attempts to transfer a given person from this settlement to another.
	 * @param p				The person.
	 * @param other			The other settlment.
	 * @return				The success of the transfer.
	 */
	public boolean transferPerson(Person p, Settlement other) {
		// Won't bother to transfer a person to the same settlement
		if (this.equals(other))
			return false;
		// Won't attempt to transfer someone who is not in the settlement.
		if (!this.people.contains(p))
			return false;
		// try to add the person to the other settlement
		boolean success = other.addPerson(p);
		// if succeded, remove from this and report true
		if (success) {
			this.people.remove(p);
			return true;
		}
		// if failed, report failure
		return false;
	}

	/**
	 * Attempts to infect a given person with a given virus.
	 * @param p				The person.
	 * @param v				The virus.
	 * @return				The result.
	 */
	public boolean infectPerson(Person p, IVirus v) {
		if (!this.people.contains(p))
			return false;
		Sick sicko = p.contagion(v);
		if (null == sicko)
			return false;
		this.people.remove(p);
		this.people.add(sicko);
		return true;
	}

	/**
	 * Getter for people.
	 * @return			The list of people.
	 */
	public List<Person> getPeople() { return this.people; }

	/**
	 * Checks how many people live in the settlement.
	 * @return			The number of people.
	 */
	public int numPeople() { return this.people.size(); }

	/**
	 * Grabs a random sucker from the crowd.
	 * @return			The rando.
	 */
	public Person getRandomPerson() {
		Random rnd = new Random();
		return this.people.get(rnd.nextInt(this.numPeople()));
	}

	/**
	 * Grabs a random victim from the crowd.
	 * @return			The victim.
	 */
	public Sick getSickPerson() {
		for (int i = 0 ; i < this.numPeople() ; ++i)
			if (!this.people.get(i).getHealthStatus())
				return (Sick)this.people.get(i);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Settlement))
			return false;
		Settlement set = (Settlement)other;
		return this.name.equals(set.name) &&
				this.people.equals(set.people) &&
				this.location.equals(set.location) &&
				this.ramzorColor.equals(set.ramzorColor);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Name: " + this.name + "\n" +
				this.location + "\n" +
				"Ramzor Code: " + this.ramzorColor + "\n" +
				"Population: \n" + this.people;
	}

	/**
	 * Getter for capacity.
	 * @return			The settlement's capacity.
	 */
	public int getCapacity() { return this.capacity; }

	/**
	 * Getter for name.
	 * @return			The name.
	 */
	public String getName() { return this.name; }
}
