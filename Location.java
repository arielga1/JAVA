package Location;

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
        this.size=size;
        /**
         * Constructor
         */
    }
    public Location() {
        this.position = new Point(0,0);
        this.size = new Size(0,0);
        /**
         * Default c'tor
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

    public boolean setPosition(Point pos) {
        this.position=pos;
        return true;
        /**
         * @param pos
         * @return true
         */
    }

    public boolean setsize(Size s)
    {
        this.size=s;
        return true;
        /**
         * @param s
         * @return true
         */
    }

    @Override
    public String toString() {
        return position + " , " + size;
    }


}


