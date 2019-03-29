package firstExample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertionsDemo {
    private final Calculator calculator = new Calculator();
    private final Person person = new Person("Vladimir", "Glinskikh");
    @Test
    void standartAssertions(){
        assertEquals(2, calculator.add(1, 1));
        assertEquals(4, calculator.multiply(2, 2));
    }
}
