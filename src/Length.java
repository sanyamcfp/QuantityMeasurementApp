public class Length {

    public static final Length INCH = new Length(2.54);
    public static final Length FEET = new Length(30.48);
    public static final Length YARD = new Length(91.44);
    public static final Length CENTIMETER = new Length(1);

    private final double conversionFactor;

    private Length(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double toBase(double value) {
        return value * conversionFactor;
    }

    public double fromBase(double baseValue) {
        return baseValue / conversionFactor;
    }
}