package firstExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Vladimir", "Glinskikh");

    @Test
    void standartAssertions() {
        assertEquals(2, calculator.add(1, 1));
        assertEquals(6, calculator.multiply(2, 3), "The optional failure message is now the last" +
                "parameter");
        assertTrue('a' < 'b', () -> "Assertion messages can be " +
                "lazily evaluated --" +
                "to avoid constructing complex messages unnecessarily.");
    }
}
