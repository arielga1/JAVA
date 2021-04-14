/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Simulation;

public class Clock {
    private static long time;

    /**
     * Resets the clock to 0.
     */
    static void reset() {
        time = 0;
    }

    /**
     * Checks the current time.
     * @return      The time.
     */
    public static long now() {
        return time;
    }

    /**
     * Tells the clock to move on.
     */
    public static void nextTick() {
        time += 1;
    }
}
