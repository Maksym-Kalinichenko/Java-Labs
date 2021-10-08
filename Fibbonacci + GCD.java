/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author maksymkalinichenko
 */
import java.util.ArrayList;
import java.util.List;

public class Lab2 {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int findGCD(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }
        if (n1 == 0) {
            return n2;
        }
        if (n1 == n2) {
            return n1;
        }
        if (n1 > n2) {
            return findGCD(n1 - n2, n2);
        }
        return findGCD(n1, n2 - n1);
    }

    public static void main(String[] args) {

        System.out.print("Index:\t\t");
        long[] time = new long[6];
        int[] fib = new int[6];

        for (int i = 40; i < 46; i++) {
            System.out.print(i + "\t\t");
        }

        System.out.println("\n----------------------------------------------------------------------------------------------------------");

        System.out.print("Fib Number:\t");
        for (int i = 40, j = 0; i < 46; i++, j++) {
            fib[j] = fib(i);
            System.out.print(fib[j] + "\t");
        }

        System.out.print("\nGCD1:\t\t\t\t");

        for (int i = 40, j = 41, k = 1; i < 45; i++, j++, k++) {
            long startTime = System.currentTimeMillis();
            System.out.print(findGCD(fib(i), fib(j)) + "\t\t");
            long endTime = System.currentTimeMillis();
            time[k] = endTime - startTime;
        }
        System.out.print("\nTime (ms):\t\t\t");
        
        for (int i = 1; i < 6; i++) {
            
            System.out.print(time[i] + "\t\t");
        }
        
        System.out.print("\nGCD2:\t\t\t\t");

        for (int i = 0, j = 1; i < 5; i++, j++) {
            long startTime = System.currentTimeMillis();
            System.out.print(findGCD(fib[i], fib[j]) + "\t\t");
            long endTime = System.currentTimeMillis();
            time[j] = endTime - startTime;
        }
        
        System.out.print("\nTime (ms):\t\t\t");
        
        for (int i = 1; i < 6; i++) {
            
            System.out.print(time[i] + "\t\t");
        }
        System.out.println();
        
    }
}
