public class Quantity {

    private final double value;
    private final Length unit;

    public Quantity(double value, Length unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.toBase(value);
    }

    public Quantity convertTo(Length targetUnit) {

        double baseValue = this.toBaseUnit();
        double convertedValue = targetUnit.fromBase(baseValue);

        return new Quantity(convertedValue, targetUnit);
    }

    public Quantity add(Quantity other, Length targetUnit) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.fromBase(sum);

        return new Quantity(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Quantity))
            return false;

        Quantity other = (Quantity) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < 0.0001;
    }
}