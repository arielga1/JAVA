package Location;

import java.util.Random;

public class Location {

    private Point position;
    private Size size;

    /**
     *
     * @param point position
     * @param size  size of
     */
    public Location(Point point, Size size) {
        this.position = point;
        this.size = size;
        /**
         * Constructor
         */
    }

    public Point getPosition()
    {
        return this.position;
        /**
         * @return position
         */
    }

    public Size getSize()
    {
        return this.size;
        /**
         * @return this.size
         */
    }

    /**
     * Gets a random point within the area of the location.
     * @return          The point.
     */
    public Point randomPoint() {
        int w = this.size.getWidth();
        int h = this.size.getHeight();
        Random rnd = new Random();

        // the position point is the upper-left point of the area
        // so for points in the area, we add a value to the x of the position
        int x = this.position.getX() + rnd.nextInt(w);
        // and subtract a value from the y of the position
        int y = this.position.getY() - rnd.nextInt(h);

        return new Point(x, y);
    }

    /**
     * Checks if a point is in the location.
     * @param p             The point.
     * @return              True if it is, false otherwise.
     */
    public boolean isIn(Point p) {
        boolean f1, f2, f3, f4;
        f1 =(p.getX() >= this.position.getX());
        f2 = (p.getX() <= this.position.getX() + this.size.getWidth());
        f3 = (p.getY() <= this.position.getY());
        f4 = (p.getY() >= this.position.getY() - this.size.getHeight());
        return f1 && f2 && f3 && f4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Location: (" + position + " , " + size + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Location))
            return false;
        Location l = (Location)other;
        return this.position.equals(((Location) other).position) &&
                this.size.equals(l.size);
    }
}


