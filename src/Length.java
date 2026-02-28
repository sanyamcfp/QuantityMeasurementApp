public enum Length {

    FEET(12),
    INCH(1);

    private final int conversionFactor;

    Length(int conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public int getConversionFactor() {
        return conversionFactor;
    }
}