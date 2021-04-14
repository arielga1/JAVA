package Country;
import java.util.List;
import Location.*;
import Population.Person;

public class Moshav extends Settlement{

	public Moshav(String name,Location location,RamzorColor ramzorcolor, Person[] people ) {
		super(name,location,ramzorcolor,people);
	}
	@Override
	public RamzorColor calculateRamzorGrade()
	{
		double p = this.contagiousPercent();
		double c = 0.3+3*Math.pow(((Math.pow(1.2,this.ramzorcolor.getValue()))*p-0.35),5);
		return RamzorColor.select(c);
	}
}