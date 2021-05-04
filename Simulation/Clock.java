package Simulation;

public class Clock {
    private static long time;
    private static long ticksperday = 1;

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

/**
 * calculates  how many days have passed since starting time.
 * @param start    starting time.
 * @return         how many days have passed.
 */
public static long timepass(long start){
    return (long) Math.ceil((double)(now() - start) / ticksperday);
}