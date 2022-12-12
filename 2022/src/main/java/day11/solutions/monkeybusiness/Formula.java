package day11.solutions.monkeybusiness;

import java.math.BigDecimal;

import lombok.Getter;

/**
 * A Formula (or operation) used to change the amount of worry about an item
 *
 */
public class Formula {

    public static final String OLD = "old";
    
    public static enum Operator {
        MULTIPLY,
        ADD,
        DIVIDE;
 
        public static Operator fromSymbol(String symbol) {
            switch(symbol) {
            case "*": return Operator.MULTIPLY;
            case "+": return Operator.ADD;
            case "/": return Operator.DIVIDE;
            default:
                throw new IllegalArgumentException(symbol);
            }
        }
        
        @Override
        public String toString() {
            switch(this) {
            case MULTIPLY: return "*";
            case ADD: return "+";
            case DIVIDE: return "/";
            }
            return null;
        }
    };
    
    @Getter
    private final Operator operator;
    
    @Getter
    private final String operand;
    private final BigDecimal bigOperand;
    
    public Formula(final Operator operator, final String operand) {
        this.operator = operator;
        this.operand = operand;
        if(!operand.equals(OLD)) {
            bigOperand = new BigDecimal(operand);
        } else {
            bigOperand = null;
        }
    }
    
    public BigDecimal apply(BigDecimal value) {
        if(operand.equals(OLD)) {
            return value.multiply(value);
        }
        
        switch(operator) {
            case ADD: return value.add(bigOperand);
            case MULTIPLY: return value.multiply(bigOperand);
            case DIVIDE: return value.divideAndRemainder(bigOperand)[0];
        }
        throw new IllegalStateException("No such operator");
    }
    
    @Override
    public String toString() {
        return "old " + operator.toString() + " " + operand;
    }
}
