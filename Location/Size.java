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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Size))
            return false;
        Size s = (Size)other;
        return (this.height == s.height) &&
                (this.width == s.width);
    }
}

