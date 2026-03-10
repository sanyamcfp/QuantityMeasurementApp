import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityTest {

    // UC3 Tests

    @Test
    void testFeetToFeetEquality() {

        Quantity q1 = new Quantity(1.0, Length.FEET);
        Quantity q2 = new Quantity(1.0, Length.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInchEquality() {

        Quantity q1 = new Quantity(1.0, Length.FEET);
        Quantity q2 = new Quantity(12.0, Length.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testFeetToInchNotEqual() {

        Quantity q1 = new Quantity(1.0, Length.FEET);
        Quantity q2 = new Quantity(13.0, Length.INCH);

        assertFalse(q1.equals(q2));
    }

    // UC4 Tests

    @Test
    void testYardToFeetEquality() {

        Quantity q1 = new Quantity(1, Length.YARD);
        Quantity q2 = new Quantity(3, Length.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testYardToInchEquality() {

        Quantity q1 = new Quantity(1, Length.YARD);
        Quantity q2 = new Quantity(36, Length.INCH);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testCmToInchEquality() {

        Quantity q1 = new Quantity(2.54, Length.CENTIMETER);
        Quantity q2 = new Quantity(1, Length.INCH);

        assertTrue(q1.equals(q2));
    }

    // UC5 Conversion Tests

    @Test
    void testFeetToInchConversion() {

        Quantity q = new Quantity(1, Length.FEET);

        Quantity result = q.convertTo(Length.INCH);

        assertEquals(new Quantity(12, Length.INCH), result);
    }

    @Test
    void testYardToFeetConversion() {

        Quantity q = new Quantity(1, Length.YARD);

        Quantity result = q.convertTo(Length.FEET);

        assertEquals(new Quantity(3, Length.FEET), result);
    }

    @Test
    void testInchToCmConversion() {

        Quantity q = new Quantity(1, Length.INCH);

        Quantity result = q.convertTo(Length.CENTIMETER);

        assertEquals(new Quantity(2.54, Length.CENTIMETER), result);
    }

    // UC6 Addition Tests

    @Test
    void testFeetAndInchAddition() {

        Quantity q1 = new Quantity(5, Length.FEET);
        Quantity q2 = new Quantity(24, Length.INCH);

        Quantity result = q1.add(q2, Length.FEET);

        assertEquals(new Quantity(7, Length.FEET), result);
    }

    @Test
    void testFeetAddition() {

        Quantity q1 = new Quantity(2, Length.FEET);
        Quantity q2 = new Quantity(3, Length.FEET);

        Quantity result = q1.add(q2, Length.FEET);

        assertEquals(new Quantity(5, Length.FEET), result);
    }

    @Test
    void testInchAddition() {

        Quantity q1 = new Quantity(10, Length.INCH);
        Quantity q2 = new Quantity(2, Length.INCH);

        Quantity result = q1.add(q2, Length.INCH);

        assertEquals(new Quantity(12, Length.INCH), result);
    }

    // UC7 Target Unit Addition

    @Test
    void testAddFeetAndInchResultInInch() {

        Quantity q1 = new Quantity(1, Length.FEET);
        Quantity q2 = new Quantity(2, Length.INCH);

        Quantity result = q1.add(q2, Length.INCH);

        assertEquals(new Quantity(14, Length.INCH), result);
    }

    @Test
    void testAddFeetAndInchResultInFeet() {

        Quantity q1 = new Quantity(1, Length.FEET);
        Quantity q2 = new Quantity(2, Length.INCH);

        Quantity result = q1.add(q2, Length.FEET);

        assertEquals(new Quantity(14.0/12.0, Length.FEET), result);
    }

    @Test
    void testAddYardAndFeetResultInFeet() {

        Quantity q1 = new Quantity(1, Length.YARD);
        Quantity q2 = new Quantity(2, Length.FEET);

        Quantity result = q1.add(q2, Length.FEET);

        assertEquals(new Quantity(5, Length.FEET), result);
    }
    @Test
void testKgToGramEquality() {

    QuantityWeight q1 = new QuantityWeight(1, WeightUnit.KILOGRAM);
    QuantityWeight q2 = new QuantityWeight(1000, WeightUnit.GRAM);

    assertTrue(q1.equals(q2));
}
}