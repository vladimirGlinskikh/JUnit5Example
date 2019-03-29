package firstExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("Vladimir", person.getFirstName()),
                () -> assertEquals("Glinskikh", person.getLastName()));
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("V")),
                            () -> assertTrue(firstName.endsWith("r")));
                },
                () -> {
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("G")),
                            () -> assertTrue(lastName.endsWith("h")));
                });
    }

    @Test
    void exceptionTesting() {
        Exception exception =
                assertThrows(ArithmeticException.class, () ->
                        calculator.divide(1, 0));
        assertEquals("/ by zero", exception.getMessage());
    }


}
