public class Quantity {

    private final double value;
    private final Length unit;

    public Quantity(double value, Length unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    public Quantity convertTo(Length targetUnit) {

        double baseValue = this.toBaseUnit();
        double convertedValue = baseValue / targetUnit.getConversionFactor();

        return new Quantity(convertedValue, targetUnit);
    }

    public Quantity add(Quantity other, Length targetUnit) {

        double sum = this.toBaseUnit() + other.toBaseUnit();

        double result = sum / targetUnit.getConversionFactor();

        return new Quantity(result, targetUnit);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!(obj instanceof Quantity))
            return false;

        Quantity other = (Quantity) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < 0.0001;
    }
}