package Task4;

public class PairValues {
    private final char symbol;
    private final int count;

    public PairValues(char symbol, int count) {
        this.symbol = symbol;
        this.count = count;
    }

    public String toString() {
        return "symbol= " + symbol + ", count= " + count;
    }

}

