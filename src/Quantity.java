import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Quantity<?> other))
            return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        return Math.abs(base1 - base2) < 0.0001;
    }

    public Quantity<U> convertTo(U targetUnit) {

        double base = unit.toBase(value);
        double converted = targetUnit.fromBase(base);

        return new Quantity<>(converted, targetUnit);
    }

    /*
    =========================
    ARITHMETIC OPERATIONS
    =========================
    */

    public Quantity<U> add(Quantity<U> other) {
        return add(other, unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double baseResult =
                performBaseArithmetic(other, ArithmeticOperation.ADD);

        double result = targetUnit.fromBase(baseResult);

        return new Quantity<>(round(result), targetUnit);
    }

    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double baseResult =
                performBaseArithmetic(other, ArithmeticOperation.SUBTRACT);

        double result = targetUnit.fromBase(baseResult);

        return new Quantity<>(round(result), targetUnit);
    }

    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(other, ArithmeticOperation.DIVIDE);
    }

    /*
    =========================
    VALIDATION HELPER
    =========================
    */

    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetRequired) {

        if (other == null)
            throw new IllegalArgumentException("Operand cannot be null");

        if (!unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Incompatible unit types");

        if (!Double.isFinite(value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (targetRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit required");
    }

    /*
    =========================
    CORE ARITHMETIC HELPER
    =========================
    */

    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double base1 = unit.toBase(value);
        double base2 = other.unit.toBase(other.value);

        return operation.compute(base1, base2);
    }

    /*
    =========================
    OPERATION ENUM
    =========================
    */

    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {
            if (b == 0)
                throw new ArithmeticException("Divide by zero");
            return a / b;
        });

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public double compute(double a, double b) {
            return operator.applyAsDouble(a, b);
        }
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}