/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lit.src;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Alan.Ryan
 */
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Locale l = new Locale("fr", "FR");
        NumberFormat nf = NumberFormat.getCurrencyInstance(l);

        Scanner sc = new Scanner(System.in);

        System.out.println("\t\tWELCOME TO TUS CARPARKS\n");
        System.out.println("Enter duration of stay (enter -1 to quit)");

        double duration = sc.nextDouble();

        while (duration != -1) {
            System.out.println("Charge is " + nf.format(calculateCharges(duration)));

            System.out.println("\nEnter duration of stay (enter -1 to quit)");

            duration = sc.nextDouble();
        }
        
        System.out.println("GOODBYE");

    }

    static double calculateCharges(double duration) {
        double totalCharge = 2.0;

        if (duration > 3) {
            totalCharge += (Math.ceil(duration) - 3) * 0.5;
        }

        if (totalCharge > 10.00) {
            totalCharge = 10.00;
        }

        return totalCharge;
    }

}
