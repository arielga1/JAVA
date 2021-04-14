package Country;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Map {
    private List<Settlement> settlements;
    private static int DEFAULT_SIZE = 10;

    /**
     * A basic constructor.
     * @param settlements       A list of settlements on the map.
     *                          If it is null, a default size
     *                          will be assigned.
     */
    public Map(List<Settlement> settlements) {
        if (settlements == null)
            this.settlements = new ArrayList<>(DEFAULT_SIZE);
        this.settlements = settlements;
    }

    /**
     * Checks the number of settlements on the map.
     * @return          The number.
     */
    public int size() { return this.settlements.size(); }

    /**
     * Index getter for settlements.
     * @param i         The index.
     * @return          The settlement at the given index.
     */
    public Settlement get(int i) {
        if (i >= this.settlements.size())
            return null;
        return this.settlements.get(i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < this.size() ; ++i) {
            sb.append(this.settlements.get(i).toString());
        }
        return sb.toString();
    }
}
