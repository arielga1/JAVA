/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
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
    public Point(Point otherPoint)
    {
        this.x = otherPoint.getX();
        this.y = otherPoint.getY();
        /**
         * @param otherPoint
         * Copy constructor
         */
    }

    /**
     * Calculates the distance between this point and another.
     * @param other             The other point.
     * @return                  The distance from it.
     */
    public double distance(Point other) {
        return Math.sqrt(
                Math.pow((this.x - other.x), 2) +
                Math.pow((this.y - other.y), 2)
        );
    }

    /**
     *
     * @return this.x
     */
    public int getX() { return this.x; }

    /**
     *
     * @return this.y
     */
    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Point (" + this.x + ", " + this.y + ")";
    }
    /**
            *
            * @return the current point
	 */

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point))
            return false;
        Point p = (Point) other;
        return (this.x == p.x) && (this.y == p.y);
    }


    public static void main(String [] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(4, 5);
        System.out.println(p1.distance(p2));
    }

}
