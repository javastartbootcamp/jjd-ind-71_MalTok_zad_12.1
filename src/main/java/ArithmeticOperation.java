import java.util.Locale;

class ArithmeticOperation {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private final double firstNumber;
    private final double secondNumber;
    private final String operator;

    public ArithmeticOperation(double firstNumber, double secondNumber, String operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    public static ArithmeticOperation fromLine(String line) {
        String[] array = line.split(" ");
        double firstNumber = Double.parseDouble(array[0]);
        String operator = array [1];
        double secondNumber = Double.parseDouble(array[2]);
        return new ArithmeticOperation(firstNumber, secondNumber, operator);
    }

    public double countResult() {
        switch (operator) {
            case PLUS -> {
                return firstNumber + secondNumber;
            }
            case MINUS -> {
                return firstNumber - secondNumber;
            }
            case MULTIPLY -> {
                return firstNumber * secondNumber;
            }
            case DIVIDE -> {
                return firstNumber / secondNumber;
            }
            default -> throw new InvalidOperatorException("No such operator");
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%.1f %s %.1f = %.1f", firstNumber, operator, secondNumber, countResult());
    }

    public String toOutputFormat() {
        return String.format(Locale.US, "%.1f %s %.1f = %.1f", firstNumber, operator, secondNumber, countResult());
    }
}
