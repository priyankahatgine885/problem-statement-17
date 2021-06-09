package com.main;
import java.util.Scanner;

public class SalesCommissions {
    public static void main(String[] args) {
        int[] ranges = new int[9];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter sales amount :");
            double amount = sc.nextInt();
            //if you want to while loop stop,you have to give a negative value
            if (amount < 0) {
                break;
            }
            getSalary(amount, ranges);
        }
        System.out.println("\nRange\t\t\tNumber");
        for (int i = 0; i < ranges.length; i++) {
            int start = (i + 2) * 100;
            int end = start + 99;
            if (i < ranges.length - 1) {
                System.out.printf("$%d-$%d\t\t%d\n", start, end, ranges[i]);
            } else {
                System.out.printf("$%d and over\t\t%d\n", start, ranges[i]);
            }
        }
    }
    private static void getSalary(double amount, int ranges[]) {
        double salary1 = salary(amount);
        int index= index(salary1);
        if (index >= ranges.length) {
            ranges[ranges.length - 1]++;
        } else {
            ranges[index]++;
        }
    }
    private static int index(double salary) {
        int index = (int) Math.floor(salary / 100 - 2);
        return index;
    }
    private static double salary(double amount) {
        double value = 200 + amount * 0.09;
        return value;
    }
}
