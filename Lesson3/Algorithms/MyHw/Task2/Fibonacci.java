package com.company.Task2;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int[] array = fibonacci(20);
        System.out.println(Arrays.toString(array));
    }

    private static int[] fibonacci(int n) {
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr;
    }
}