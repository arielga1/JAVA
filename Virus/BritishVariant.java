package Virus;
import Virus.IVirus;
import java.util.Random;

public class BritishVariant extends Virus {
    /**
     * The constructor for the british variant of the virus.
     */
    public BritishVariant() { super(18, 0.01, 0.1, 0.7, 0.7); }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() { return "British Variant"; }
}

