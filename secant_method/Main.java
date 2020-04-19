package com.secant_method;

import java.util.*;
import java.text.DecimalFormat;
public class Main {

    public static void main(String[] args) {
        DecimalFormat df4 = new DecimalFormat("#.####");
        double cord1, cord2, new_number, tolerance, diff;
        int iteration = 1;
        int checker = 1;
         do {
            try {
                Scanner ip1 = new Scanner(System.in);
                Scanner ip2 = new Scanner(System.in);
                Scanner ip3 = new Scanner(System.in);
                System.out.print("Enter the coordinates\na= ");
                cord2 = ip1.nextDouble();
                System.out.print("b= ");
                new_number = ip2.nextDouble();
                System.out.print("Enter the accuracy: ");
                tolerance = ip3.nextDouble();
                System.out.printf("%10s%15s%10s%10s%10s%10s%n", "Iteration", "a", "b", "c", "f(c)", "|cn-c|");

                do {
                    cord1 = cord2;
                    cord2 = new_number;
                    new_number = cord2 - ((function (cord2) * (cord2 - cord1)) / (function(cord2) - function(cord1))); // Formula for finding the root
                    diff = new_number - cord2;
                    System.out.printf("%10s%15s%10s%10s%10s%10s%n", iteration, df4.format(cord1), df4.format(cord2), df4.format(new_number), df4.format(function(new_number)), df4.format(Math.abs(diff)));
                    if (function(new_number) == 0) {
                        System.out.println("The root is " + df4.format(new_number));
                    }
                    iteration++;

                } while (Math.abs(diff) > tolerance);
                System.out.println("The root is " + df4.format(new_number));
                checker = 2;
            }
            catch (ArithmeticException ex) {
                System.out.println("There was a problem with the calculation. Please re-enter coordinates.");
                System.out.println();
            }
            catch (InputMismatchException ex) {
                System.out.println("Wrong input type. Please try again.");
                System.out.println();
            }
            catch (NumberFormatException ex) {
                System.out.println("Wrong number format. Please try again.");
                System.out.println();
            }
            catch (Exception e) {
                System.out.println("Please check your inputs and make sure they are valid.");
                System.out.println();
            }
        }while(checker == 1);
    }

    // Function for solving f(x)
    private static double function(double a){
        return 3 * Math.pow(a, 3) - Math.pow(a,2); // Predefined function(i.e 3x^3 - x^2)
    }
}
