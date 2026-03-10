public enum Length implements IMeasurable {

    FEET(12),
    INCH(1),
    YARD(36),
    CENTIMETER(0.393701);

    private final double conversionFactor;

    Length(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    public String getUnitName() {
        return this.name();
    }
}