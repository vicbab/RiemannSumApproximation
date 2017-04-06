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
    public static final int N = 100;
    // public static final int N = 15;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] funcX = new double[8];
        double sum;
        fillTestFunction(funcX);
        sum = getSum(0, 100, funcX);
        System.out.println(sum);
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
            double delX = (b - a) / N;
            for (int i = a; i <= b; i++) {
                result += (funcX(i, 2) * delX);
            }
            return result;
        } else {
            return 0;
        }
    }

    public static void fillTestFunction(double[] funcX) {
        for (int i = 0; i < 8; i++) {
            funcX[i] = Math.pow(i, 2);
        }
    }

    public static double funcX(double x, double puissance) {
        return Math.pow(x, puissance);
    }
}
