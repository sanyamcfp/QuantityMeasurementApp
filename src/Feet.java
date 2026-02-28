public class Feet {

    private final double value;

    public Feet(double value) {
        this.value = value;
    }

    public double toInches() {
        return value * 12;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (obj instanceof Feet) {
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        if (obj instanceof Inch) {
            Inch other = (Inch) obj;
            return Double.compare(this.toInches(), other.getValue()) == 0;
        }

        return false;
    }
}