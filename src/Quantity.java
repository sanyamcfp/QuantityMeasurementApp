public class Quantity {

    private final double value;

    public Quantity(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Quantity other = (Quantity) obj;

        return Double.compare(this.value, other.value) == 0;
    }
}