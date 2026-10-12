import java.util.Scanner;

public class Question1 {

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    static double remainder(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot find remainder with zero.");
        }
        return a % b;
    }

    static double square(double a) {
        return a * a;
    }

    static double cube(double a) {
        return a * a * a;
    }

    static double absolute(double a) {
        return Math.abs(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("\\nAddition = " + add(a, b));
        System.out.println("Subtraction = " + subtract(a, b));
        System.out.println("Multiplication = " + multiply(a, b));

        try {
            System.out.println("Division = " + divide(a, b));
            System.out.println("Remainder = " + remainder(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Square of first number = " + square(a));
        System.out.println("Cube of first number = " + cube(a));
        System.out.println("Absolute value of first number = " + absolute(a));

        sc.close();
    }
}
