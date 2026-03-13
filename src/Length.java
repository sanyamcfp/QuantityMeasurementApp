public enum Length implements IMeasurable {

    FEET(1.0),
    INCH(1.0 / 12.0),
    YARD(3.0),
    CENTIMETER(1.0 / 30.48);

    private final double toBase;

    Length(double toBase) {
        this.toBase = toBase;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * toBase;
    }

    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / toBase;
    }
}