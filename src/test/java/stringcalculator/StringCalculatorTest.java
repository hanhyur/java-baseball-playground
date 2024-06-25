package stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    
    private StringCalculator stringCalculator;
    
    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }
    
    @Test
    void add() {
        assertThat(stringCalculator.add(10, 20)).isEqualTo(30);
    }
    
    @Test
    void subtract() {
        assertThat(stringCalculator.subtract(20, 10)).isEqualTo(10);
    }
    
    @Test
    void multiply() {
        assertThat(stringCalculator.multiply(10, 20)).isEqualTo(200);
    }
    
    @Test
    void divide() {
        assertThat(stringCalculator.divide(20, 10)).isEqualTo(2);
    }
    
    @Test
    void failDivide() {
        assertThatThrownBy(() -> {
            stringCalculator.divide(1, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    void failCalculate() {
        assertThatThrownBy(() -> {
            stringCalculator.calculate(10, "^", 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    
}