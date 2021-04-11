package Virus;
import Virus.IVirus;
import java.util.Random;

public class BritishVariant implements IVirus
    public double contagionProbability(Person person){
         return  person.cotagionProbability() * 0.7;
    }

    public boolean tryToKill(Sick sick){
        double probability;
        if (sick.getage() <= 18) {probability = 0.01;}
        else {probability=0.10;}
        long contagious_time=sick.contagioustime();
        Random r = new Random();
        double Val = 0+(1)*r.nextDouble();
        double dead=Math.max(0,Val-0.01*Val*(Math.pow(contagious_time-15,2)));
        return dead==probability;
    }

    public boolean tryToContagion(Person person1,Person person2){
        if (person2 instanceof Sick) {
            System.out.println("This person is already sick");
            return false;
        } 
        double p1_x=person1.getLocationX();
	    double p1_y=person1.getLocationY();
	    double p2_x=person2.getLocationX();
	    double p2_y=person2.getLocationY();
	    double distans= Math.sqrt((p2_y-p1_y)(p2_y-p1_y) + (p2_x-p1_x)(p2_x-p1_x));
        double result=contagionProbability(person2)*Math.min(1,0.14*Math.pow(Math.E,2-0.25*distans));
        System.out.println("A person's probability of being infected by another person is"+result);
        return true;
    }
}

