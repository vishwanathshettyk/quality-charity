package com.quality.charity.practices;

public class PrintFibonacciNumber {


    public static void fibonacciNumber(int count)
    {
        int a = 0;
        int b = 1;
        int c = 1;

        //fibonacci means 0, 1, 1, 2, 3,5,8...
        for(int i = 0 ; i<= count ; i++)
        {
            System.out.print(a + ",");

            a = b;
            b = c;
            c = a+b;
        }
    }
}
