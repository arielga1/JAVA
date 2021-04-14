package Country;
import java.util.List;
import Location.Location;
import Population.Person;


public class Kibbutz extends Settlement{

	public Kibbutz(String name,Location location,RamzorColor ramzorcolor, Person[] people ) {
		super(name,location,ramzorcolor,people);
	}
	public RamzorColor calculateRamzorGrade()
	{
		double p = this.contagiousPercent();
		double c = 0.45+1*(Math.pow(Math.pow(1.5, C)*(P-0.4), 3));
		return RamzorColor.calculate(c);
	}
}

