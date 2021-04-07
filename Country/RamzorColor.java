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

    public static void main(String [] args) {
        System.out.println(RamzorColor.Green.coefficient());
    }
}
