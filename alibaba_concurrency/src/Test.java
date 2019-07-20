// Program to print all prime factors
import java.io.*;
import java.lang.Math;

class primeFactors
{
    // A function to print all prime factors
    // of a given number n
    public static void primeFactors(int n)
    {
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            System.out.print(2 + " ");
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                System.out.print(i + " ");
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }

    public static void main (String[] args)
    {
        int n = 65;
        primeFactors(n);
    }
}


// Java implementation of program

class commDiv
{
    // method to calculate gcd of two numbers
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a,a);
    }
    // method to calculate all common divisors
    // of two given numbers
    // a, b --> input integer numbers
    static int commDiv(int a,int b)
    {
        // find gcd of a,b
        int n = gcd(a, b);
        System.out.println(n);

        // Count divisors of n.
        int result = 0;
        for (int i=1; i<=Math.sqrt(n); i++)
        {
            // if 'i' is factor of n
            if (n%i==0)
            {
                // check if divisors are equal
                if (n/i == i)
                    result += 1;
                else
                    result += 2;
            }
        }
        return result;
    }

    // Driver method
    public static void main(String args[])
    {
        int a = 24, b = 15;
        System.out.println(commDiv(a, b));
    }
}