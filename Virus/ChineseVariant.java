package Virus;

public class ChineseVariant extends Virus implements IVirus {
    /**
     * The constructor of the chinese variant of the virus.
     */
    public ChineseVariant() {
        super(18, 55, 0.2, 0.5, 0.7, 0.001, 0.05, 0.1);
    }
}
