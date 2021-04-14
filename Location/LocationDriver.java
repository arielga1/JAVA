package Location;

public class LocationDriver {
    public static void main(String [] args) {
        Point p = new Point(19,5);
        Size s = new Size(20, 20);
        Location l = new Location(new Point(0, 20), s);

        System.out.println(l.isIn(p));
    }
}
