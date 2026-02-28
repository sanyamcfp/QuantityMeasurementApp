public class Inch {

    private final double value;

    public Inch(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double toFeet() {
        return value / 12;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (obj instanceof Inch) {
            Inch other = (Inch) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        if (obj instanceof Feet) {
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.toInches()) == 0;
        }

        return false;
    }
}