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

    public Size(Size otherSize) {
        this.width = otherSize.getWidth();
        this.height = otherSize.getHeight();
        /**
         * Copy constructor
         */
    }

    public Size() {

    }

    public int getWidth() { return this.width; }
    /**
     *
     * @return this.width
     */
    public int getHeight() {
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
        return (this.getWidth()==size.getWidth() && this.getHeight()==size.getHeight());
        /**
         * Checks if two sizes are the same
         */
    }


}

