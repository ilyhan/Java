package com.university;

import java.util.Map;
import java.util.Stack;

public class Calculator {

    public static boolean containsFunction(String input) {
        try {
            EFunction.fromName(input);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static boolean isValid(char[] tokens) {
        Stack<Character> stack = new Stack<>();

        for (char token : tokens) {
            if (token == ' ')
                continue;
            if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (!Character.isDigit(token) && !isOperator(token) && token != '.'
                    && !Character.isLetter(token)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static double calculate(String expression, Map<String, Double> variables) {
        char[] tokens = expression.toCharArray();

        if (!isValid(tokens)) {
            throw new IllegalArgumentException("Некорректное выражение");
        }

        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }

            if (Character.isDigit(tokens[i])) {
                StringBuilder num = new StringBuilder();

                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    num.append(tokens[i++]);
                }

                values.push(Double.parseDouble(num.toString()));
                i--;
            } else if (Character.isLetter(tokens[i])) {
                StringBuilder varName = new StringBuilder();
                boolean isFunc = false;

                while (i < tokens.length && (Character.isLetter(tokens[i]) || tokens[i] == '(')) {
                    if (tokens[i] == '(') {
                        isFunc = true;
                        i++;
                        break;
                    } else {
                        varName.append(tokens[i++]);
                    }
                }

                if (isFunc) {
                    String funcName = varName.toString();
                    StringBuilder num = new StringBuilder();
                    
                    while (i < tokens.length && tokens[i] != ')') {
                        num.append(tokens[i++]);
                    }
                    
                    String arg = num.toString();
                    
                    EFunction func = EFunction.fromName(funcName);
                    
                    try {
                        double value = Double.parseDouble(arg);
                        values.push(func.apply(value));
                    } 
                    catch (NumberFormatException e) {
                        if (!variables.containsKey(arg)) {
                            throw new IllegalArgumentException("Неизвестная переменная: " + arg);
                        }
                        double variableValue = variables.get(arg);
                        values.push(func.apply(variableValue));
                    }
                } else {
                    String variable = varName.toString();
                    if (!variables.containsKey(variable)) {
                        throw new IllegalArgumentException("Неизвестная переменная: " + variable);
                    }

                    values.push(variables.get(variable));
                    i--;
                }
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }

                operators.pop();
            } else if (isOperator(tokens[i])) {
                while (!operators.empty() && getPrecedence(tokens[i]) <= getPrecedence(operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }

                operators.push(tokens[i]);
            }
        }

        while (!operators.empty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + operator);
        }
    }
}