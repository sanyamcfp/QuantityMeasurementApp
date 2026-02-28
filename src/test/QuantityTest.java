import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityTest {

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
}