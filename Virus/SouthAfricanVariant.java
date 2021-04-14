/*
Nikolay Babkin  321123242
Ariel Genezya   313532798
 */
package Virus;

public class SouthAfricanVariant extends Virus {
	/**
	 * The constructor for the south african variant of the virus.
	 */
	public SouthAfricanVariant() { super(18, 0.05, 0.08, 0.6, 0.5); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() { return "South-African Variant"; }
}
