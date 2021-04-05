package Location;

public class Point {
    private int x, y;
    /**
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        /**
         *constructs and initializes a point on position (x,y)
        */
    }
    public Point(Point otherpoint)
    {
        this.x=otherpoint.getX();
        this.y=otherpoint.getY();
        /**
         * @param otherpoint
         * Copy constructor
         */
    }

    public Point() {
    }
    public int getX() { return this.x;}
    /**
     *
     * @return this.x
     */
    public int getY() {
        return this.y;
    }
    /**
     *
     * @return this.y
     */

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
    /**
            *
            * @return the current point
	 */

    public boolean equals(Point point) {
       return (this.getY()==point.getY() && this.getX()==point.getX());
    }

}
