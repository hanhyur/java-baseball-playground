package stringcalculator;

public class StringCalculator {
    
    int add(int leftValue, int rightValue) {
        return leftValue + rightValue;
    }
    
    int subtract(int leftValue, int rightValue) {
        return leftValue - rightValue;
    }
    
    int multiply(int leftValue, int rightValue) {
        return leftValue * rightValue;
    }
    
    int divide(int leftValue, int rightValue) {
        if (rightValue == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        }
        return leftValue / rightValue;
    }
    
    int calculate(int leftValue, String operator, int rightValue) {
        if (operator.equals("+")) {
            return add(leftValue, rightValue);
        }
        
        if (operator.equals("-")) {
            return subtract(leftValue, rightValue);
        }
        
        if (operator.equals("*")) {
            return multiply(leftValue, rightValue);
        }
        
        if (operator.equals("/")) {
            return divide(leftValue, rightValue);
        }
        
        throw new IllegalArgumentException("Operator is not supported");
    }
}
