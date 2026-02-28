public enum Length {

    INCH(2.54),
    FEET(30.48),
    YARD(91.44),
    CENTIMETER(1);

    private final double conversionFactor;

    Length(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}