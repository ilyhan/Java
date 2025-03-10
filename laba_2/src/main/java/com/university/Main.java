package com.university;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Главный класс программы, который запрашивает у пользователя математическое выражение,
 * обрабатывает и запрашивает  переменные и выводит результат вычисления
 */
public class Main {
    /**
     * Вход в программу
     * Запрашивает у пользователя выражение, обрабатывает и запрашивает переменные и вычисляет результат
     * @param args Аргументы командной строки
     */
    public static void main(String[] args) {
        System.out.println("Введите выражение для рассчета");
        Scanner in = new Scanner(System.in);

        String expression = in.nextLine();
        Map<String, Double> variables = new HashMap<>();
        char[] tokens = expression.toCharArray();

        for (int i = 0; i < expression.length(); i++) {
            if (Character.isLetter(tokens[i])) {
                StringBuilder varName = new StringBuilder();

                while (i < tokens.length && Character.isLetter(tokens[i])) {
                    varName.append(tokens[i++]);
                }
                i--;

                String variable = varName.toString();

                if (!variables.containsKey(variable) && !Calculator.containsFunction(variable)) {
                    System.out.print("Введите значение для переменной " + variable + ": ");
                    double value = in.nextDouble();
                    variables.put(variable, value);
                }
            }
        }

        try {
            double result = Calculator.calculate(expression, variables);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());    
        }

        in.close();
    }
}