package com.quality.charity.practices;

public class PrimeNumberChecker {

    public static boolean isPrime(Integer number) {

        //prime means anything which cannot be divided by anyone other number == 2, 3,5
        if (number == 0 || number == 1) {
            return false;
        } else if (number == 2) {
            return true;
        }else

        for (int i = 2; i <= number / 2; i++) {

            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
