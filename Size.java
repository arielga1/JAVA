package Location;

public class Size {
    private int width;
    private int height;
    /**
     * @param width width of
     * @param height height of
     */

    public Size(int width, int height) {
        /**
         * init
         */
        this.width = width;
        this.height = height;
    }

    public Size(Size othersize) {
        this.width=othersize.getwidth();
        this.height=othersize.getheight();
        /**
         * Copy constructor
         */
    }

    public Size() {

    }

    public int getwidth() { return this.width;}
    /**
     *
     * @return this.width
     */
    public int getheight() {
        return this.height;
        /**
         *
         * @return this.height
         */
    }


    public String toString() {
        return "Size [width=" + width + ", height=" + height + "]";
    }
    /**
     *
     * @return the size
     */

    public boolean equals(Size size) {
        return (this.getwidth()==size.getwidth() && this.getheight()==size.getheight());
        /**
         * Checks if two sizes are the same
         */
    }


}

