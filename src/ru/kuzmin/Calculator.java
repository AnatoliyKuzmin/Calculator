package ru.kuzmin;


import java.util.Scanner;

/*
Класс реализует калькулятор (консольный ввод)
*/
public class Calculator {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Double first = getfirst();
        String operation = getOperation();
        Double second = getsecond();
        double result = calc(first, second, operation);
        System.out.println("Результат операции: " + result);
    }

    /*
     *Ввод числа first
     */
    public static double getfirst() {
        System.out.println("Введите первое число:");
        double first;
        if (scanner.hasNextDouble()) {
            first = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            first = getfirst();
        }
        return first;
    }

    /*
     *Ввод числа second
     */
    public static double getsecond() {
        System.out.println("Введите второе число:");
        double second;
        if (scanner.hasNextDouble()) {
            second = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            second = getsecond();
        }
        return second;
    }

    /*
     *Ввод оператора (+, -, *, /, ^)
     */
    public static String getOperation() {
        System.out.println("Введите операцию:");
        String operation;
        if (scanner.hasNext()) {
            operation = scanner.next();
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    /*
     *Вычисления согласно оператору
     * result - результат вычислений
     */
    public static double calc(double first, double second, String operation) {
        double result;
        if ("+".equals(operation)) {
            result = first + second;
        } else if ("-".equals(operation)) {
            result = first - second;
        } else if ("*".equals(operation)) {
            result = first * second;
        } else if ("/".equals(operation)) {
            if (second != 0d) {
                result = first / second;
            } else {
                throw new ArithmeticException("На ноль делить нельзя!!! Попробуйте ввести второе число заново");
            }
        } else if ("^".equals(operation)) {
            result = Math.pow(first, second);
        } else {
            throw new UnsupportedOperationException();
        }
        return result;
    }
}

