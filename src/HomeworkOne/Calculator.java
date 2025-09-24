import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите операцию (+, -, *, /, ^, sqrt, ln, !, prime):");
        String op = sc.next();

        switch (op) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                System.out.println("Введите два числа:");
                double a = sc.nextDouble();
                double b = sc.nextDouble();
                System.out.println("Результат: " + calculateBasic(op, a, b));
                break;

            case "sqrt":
            case "ln":
                System.out.println("Введите число:");
                double x = sc.nextDouble();
                System.out.println("Результат: " + calculateAdvanced(op, x));
                break;

            case "!":
                System.out.println("Введите целое число:");
                int n = sc.nextInt();
                System.out.println("Факториал: " + factorial(n));
                break;

            case "prime":
                System.out.println("Введите целое число:");
                int p = sc.nextInt();
                System.out.println("Простое? " + isPrime(p));
                break;

            default:
                System.out.println("Неизвестная операция.");
        }

        sc.close();
    }

    static double calculateBasic(String op, double a, double b) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b != 0 ? a / b : Double.NaN;
            case "^" -> Math.pow(a, b);
            default -> Double.NaN;
        };
    }

    static double calculateAdvanced(String op, double x) {
        return switch (op) {
            case "sqrt" -> Math.sqrt(x);
            case "ln" -> Math.log(x);
            default -> Double.NaN;
        };
    }

    static long factorial(int n) {
        if (n < 0) return -1;
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }
}