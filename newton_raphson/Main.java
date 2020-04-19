package com.newton_raphson;
import java.util.*;
//import java.math.RoundingMode;
import  java.text.DecimalFormat;
public class Main {

    public static void main(String[] args) {
        DecimalFormat df4 = new DecimalFormat("#.####");
        double number, iniNum, fx, fx1, tolerance, diff;
        int iteration = 0;
        int checker = 1;
        do {
            try {
                Scanner input1 = new Scanner(System.in);
                Scanner input2 = new Scanner(System.in);
                System.out.print("Enter initial guess: ");
                iniNum = input1.nextDouble();
                //System.out.println();
                System.out.print("Enter the accuracy: ");
                tolerance = input2.nextDouble();
                System.out.printf("%10s%10s%10s%15s%n", "Iteration", "x(i)", "x(i+1)", "|x(i+1)-x(1)|");

                do {
                    number = iniNum;
                    fx = f_OfX(number);
                    fx1 = f_OfXPrime(number);
                    iniNum = number - (fx / fx1);
                    diff = iniNum - number;
                    iteration++;
                    //df4.setRoundingMode(RoundingMode.DOWN);
                    System.out.printf("%10s%10s%10s%15s%n", iteration, df4.format(number), df4.format(iniNum), df4.format(Math.abs(diff)));
                } while (Math.abs(diff) >= tolerance);

                //df4.setRoundingMode(RoundingMode.DOWN);
                System.out.println("The root is " + df4.format(iniNum));
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
        }while (checker == 1);

    }

    private static double f_OfX(double x){
       return Math.sin(x); // Predefined function(i.e f(x) = sin(x))
    }

    private static double f_OfXPrime(double x){
        return Math.cos(x); // Predefined function for the second derivative of the function(i.e f'(x) = cos(x))
    }
}
