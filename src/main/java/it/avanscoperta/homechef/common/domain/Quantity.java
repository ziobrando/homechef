package it.avanscoperta.homechef.common.domain;

/**
 * This is a value object to deal with quantities.
 * I just did things quickly here, driven by the need to see good code somewhere else.
 *
 * There is probably some library that solves this problem, but I haven't faced the real problem yet.
 */
public class Quantity {
    private final double qty;
    public Quantity(double qty) {
        this.qty = qty;
    }

    public static Quantity grams(double i) {
        return new Grams(i);
    }

    public static Quantity units(int i) { return new Units(i); }

    private static class Units extends Quantity {
        public Units(int i) {
            super(i);
        }
    }
}


class Grams extends Quantity {
    public Grams(double qty) {
        super(qty);
    }
}
