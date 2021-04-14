package Country;
import java.util.List;

public class City extends Settlement {
	public City(String name,Location location,RamzorColor ramzorcolor, Person[] people ) {
		super(name,location,ramzorcolor,people);
	}
	
	public City(City c) {
		super(c.get_Name(),c.get_Location(),c.get_People(),c.get_RamzorColor());}
			
	public RamzorColor calculateRamzorGrade() { 
		double p = this.contagiousPercent();
		double c = 0.2*(Math.pow(4,1.25*p));
		return RamzorColor.select(c);
	}
}
