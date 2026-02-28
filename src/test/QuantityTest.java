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
}