package com.company.Task4;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getPrimeNumbers(100)));
    }

    // Решето Аткина
    private static int[] getPrimeNumbers(int limit) {
        boolean[] isPrimes = new boolean[limit + 1];
        double sqrt = Math.sqrt(limit);

        for (int x = 1; x <= sqrt; x++) {
            for (int y = 1; y <= sqrt; y++) {
                int x2 = x * x;
                int y2 = y * y;
                int n = 4 * x2 + y2;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    isPrimes[n] ^= true;
                }

                n -= x2;
                if (n <= limit && n % 12 == 7) {
                    isPrimes[n] ^= true;
                }

                n -= 2 * y2;
                if (x > y && n <= limit && n % 12 == 11) {
                    isPrimes[n] ^= true;
                }
            }
        }

        for (int n = 5; n <= sqrt; n += 2) {
            if (isPrimes[n]) {
                int s = n * n;
                for (int k = s; k <= limit; k += s) {
                    isPrimes[k] = false;
                }
            }
        }
        isPrimes[2] = true;
        isPrimes[3] = true;

        int[] primeNumbers = new int[limit];
        int index = 0;
        for (int i = 0; i < limit; i++) {
            if(isPrimes[i]) {
                primeNumbers[index] = i;
                index++;
            }
        }
        return Arrays.copyOf(primeNumbers, index);
    }
}
