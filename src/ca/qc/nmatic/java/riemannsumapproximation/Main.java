/*
 * Author: Victor Babin (vicbab)
 * Project: RiemannSumApproximation
 * Description: A tool to get an approximation of a Riemann sum.
 * Version: v1.0 beta
 */
package ca.qc.nmatic.java.riemannsumapproximation;

import java.lang.Math;
import java.util.Scanner;

/**
 *
 * @author Victor Babin
 */
public class Main {

    public static final int K = 0;
    public static final double N = Math.pow(2, 17);
    // funcX(a + delX * i, 1, 10, 30)

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double sum, borneSup, borneInf;
        boolean restart = true;
        Scanner sc = new Scanner(System.in);
        while(restart){
            try {
                System.out.print("Borne supérieure: ");
                borneSup = Integer.parseInt(sc.nextLine());
                System.out.print("Borne inférieure: ");
                borneInf = Integer.parseInt(sc.nextLine());
                sum = getSum(borneInf, borneSup);
                System.out.println("Area under the curve: " + sum);
                restart = false;
            } catch (NumberFormatException e) {
                restart = true;
            }    
        }        
    }

    /**
     * @param a borne inférieure
     * @param b borne supérieure
     * @return result for a sum
     */
    public static double getSum(double a, double b) {
        if (b > a) {
            double result = 0;
            int numberOfIterations = K;
            double delX = (b - a) / N;
            for (int i = K; i < N; i++) {
                result += (funcX(a + delX * i, 1, 0, 1) * delX);
                numberOfIterations++;
            }
            System.out.println("Number of iterations: " + numberOfIterations);
            return result;
        } else {
            return 0;
        }
    }

    public static double funcX(double x, double puissance, double constante, double coefficient) {
        return (coefficient * Math.pow(x, puissance) + constante);
    }
}
