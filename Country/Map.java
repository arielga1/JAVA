package Country;

/**
 *
 */
public class Map {
    private Settlement[] settlements;
    private static int DEFAULT_SIZE = 10;

    /**
     * A basic constructor.
     * @param settlements       A list of settlements on the map.
     *                          If it is null, a default size
     *                          will be assigned.
     */
    public Map(Settlement[] settlements) {
        if (settlements == null)
            this.settlements = new Settlement[10];
        this.settlements = settlements;
    }
}
