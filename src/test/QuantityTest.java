import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuantityTest {

    @Test
    void testEquality() {

        Quantity q1 = new Quantity(1.0);
        Quantity q2 = new Quantity(1.0);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testNotEqual() {

        Quantity q1 = new Quantity(1.0);
        Quantity q2 = new Quantity(2.0);

        assertFalse(q1.equals(q2));
    }

    @Test
void testFeetToInchEquality() {

    Feet oneFoot = new Feet(1.0);
    Inch twelveInch = new Inch(12.0);

    assertTrue(oneFoot.equals(twelveInch));
}

@Test
void testFeetToInchNotEqual() {

    Feet oneFoot = new Feet(1.0);
    Inch thirteenInch = new Inch(13.0);

    assertFalse(oneFoot.equals(thirteenInch));
}
}