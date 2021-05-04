/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Country;

/**
 *
 */
public enum RamzorColor {
    GREEN(0.4, 1.0, Color.GREEN),
    YELLOW(0.6, 0.8, Color.YELLOW),
    ORANGE(0.8, 0.6, Color.ORANGE),
    RED(1.0, 0.4, Color.RED);
    private double value;

    /**
     * Constructor.
     * @param v             The value of the coefficient.
     */
   RamzorColor(double v), double vt, Color color){ this.value = v; }
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
        if (v > 0 && v <= 0.4) return GREEN;
        if (v > 0.4 && v <= 0.6) return YELLOW;
        if (v > 0.6 && v <= 0.8) return ORANGE;
        if (v > 0.8 && v <= 1.0) return RED;
        return GREEN;
    }

    public static void main(String [] args) {
        System.out.println(RamzorColor.Green.coefficient());
    }
}

