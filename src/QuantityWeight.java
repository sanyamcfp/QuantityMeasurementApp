public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    public QuantityWeight(double value, WeightUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    private double toBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < 0.0001;
    }

    public QuantityWeight convertTo(WeightUnit targetUnit) {

        double baseValue = this.toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(converted, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = this.unit.convertFromBaseUnit(sum);

        return new QuantityWeight(result, this.unit);
    }

    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {

        double sum = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sum);

        return new QuantityWeight(result, targetUnit);
    }
}