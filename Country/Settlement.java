package Country;

import Location.*;
import Population.Person;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class Settlement {
    private String name;
    private Location location;
    private List<Person> people;
    private RamzorColor ramzorColor;

    /**
     * The constructor.
     * @param name          The name of the settlement.
     * @param location      The location of the settlement.
     * @param people        The people living in the settlement.
     */
    public Settlement(String name, Location location,
                      List<Person> people, RamzorColor ramzorColor) {
                        this.name = name;
                        this.location = location;
                        if (people == null) {
                            this.people = new ArrayList<>();
                        }
                        this.people = people;
                        this.ramzorColor = RamzorColor.Green;
    }

    /**
     * Calculates the ramzor grade of the city.
     * @return              The grade.
     */
	public String get_Name() {
		return name;
	}
	public Location get_Location() {
		return location;
	}
	
	public List<Person> get_People() {
		return people;
	}
	public RamzorColor get_RamzorColor() {
		return ramzorColor;
	}
	
	public void set_People(List<Person> p) {
		this.people.clear();
		for(int i=0;i<p.size();++i)
			this.people.add(i, p.get(i));
	}
	public void set_Name(String name) {
		this.name = name;
	}
	
	public void set_Location(Location location) {
		this.location = location;
	}
	
	public void set_RamzorColor(RamzorColor ramzorColor) {
		this.ramzorColor = ramzorColor;
	}
	
	public abstract RamzorColor calculateRamzorGrade();
	
	
	public double contagiousPercent() { 
		int count=0;
		for (int i=0;i<people.size();++i)
		{
			if (people.get(i) instanceof Sick)
				++count;
		}
		return count/people.size();
	}
	
	public Point randomLocation()
	{
		return new Point((int)Math.random(),(int)Math.random());
	}
	
    public abstract RamzorColor calculateRamzorGrade();
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Settlement))
            return false;
        Settlement set = (Settlement)other;
        return this.name.equals(set.name) &&
                this.location.equals(set.location) &&
                this.people.equals(set.people) &&
                this.ramzorColor.equals(set.ramzorColor);
    }
    
	public boolean transferPerson(Person person, Settlement settlement) {
		return true;
	}
	
	public boolean addPerson(Person p) {
		Person [] new_people= new Person[people.length+1];
		for(int i=0;i<new_people.length;i++)
		{
			new_people[i]=this.people[i];
		}
		new_people[new_people.length-1]=p;
		return true;
	}
}
