package Country;

/**
 *
 */
public enum RamzorColor {
    Green(0.4), Yellow(0.6), Orange(0.8), Red(1.0);

    private double value;

    /**
     * Constructor.
     * @param v             The value of the coefficient.
     */
    RamzorColor(double v) { this.value = v; }

    /**
     * Retrieves the coefficient of the color.
     * @return              The coefficient.
     */
    public double coefficient() { return this.value; }

    /**
     * Assigns a ramzor grade to a given value.
     * @param value         The value.
     * @return              The grade for the value.
     */
    public static RamzorColor getGrade(double value) {
        if (value <= Green.value)
            return Green;
        else if (value <= Yellow.value)
            return Yellow;
        else if (value <= Orange.value)
            return Orange;
        else
            return Red;
    }

    public static void main(String [] args) {
        System.out.println(RamzorColor.Green.coefficient());
    }
}
