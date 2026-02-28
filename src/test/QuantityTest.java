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

    // UC5 Tests (Conversion)

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
}