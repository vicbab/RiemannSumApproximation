/*
 * Author: Victor Babin (vicbab)
 * Project: RiemannSumApproximation
 * Description: A tool to get an approximation of a Riemann sum.
 * Version: v1.0 beta
 */
package ca.qc.nmatic.java.riemannsumapproximation;

import java.lang.Math;

/**
 *
 * @author Victor Babin
 */
public class Main {

    public static final int K = 0;
    public static final double N = Math.pow(2, 17);
    // public static final int N = 15;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] funcX = new double[8];
        double sum;
        sum = getSum(0, 10, funcX);
        System.out.println("Area under the curve: " + sum);
    }

    /**
     * @param a borne inférieure
     * @param b borne supérieure
     * @param funcX the function in question
     * @return result for a sum
     */
    public static double getSum(int a, int b, double[] funcX) {
        if (b > a) {
            double result = 0;
            int numberOfIterations = K;
            double delX = (b - a) / N;
            for (int i = K; i < N; i++) {
                result += (funcX(a + delX * i, 1) * delX);
                numberOfIterations++;
            }
            System.out.println("Number of iterations: " + numberOfIterations);
            return result;
        } else {
            return 0;
        }
    }

    public static double funcX(double x, double puissance) {
        return Math.pow(x, puissance);
    }
}
