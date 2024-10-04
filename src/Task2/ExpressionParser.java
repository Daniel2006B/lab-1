package Task2;

import java.util.Scanner;

public class ExpressionParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an expression: ");
        String userExpression = scanner.nextLine();

        String result = evaluate(userExpression);
        System.out.println(result);

        scanner.close();
    }

    public static String evaluate(String userExpression) {
        String[] parts = userExpression.split(" ");

        int computedValue = performCalculation(parts);
        char lastCharacter = userExpression.charAt(userExpression.length() - 1);

        if (Character.isDigit(lastCharacter)) {
            return userExpression + " = " + computedValue;
        } else if (lastCharacter == '=' || lastCharacter == '?') {
            return userExpression.substring(0, userExpression.length() - 1) + " = " + computedValue;
        } else {
            return "Invalid character at the end of the expression.";
        }
    }

    public static int performCalculation(String[] parts) {
        int result = 0;
        int number1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int number2 = Integer.parseInt(parts[2]);

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    throw new ArithmeticException("Division by zero is not possible.");
                }
                result = number1 / number2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator. Please use +, -, *, or /.");
        }

        return result;
    }
}
