package com.example.monakom_cloud.data_structure_algorithm;

public class Recursion {

    public int factorial(int n) {
        System.out.println("n : "+n);

        if ( n<0 ) { return -1; }
        if (n==0 || n == 1){ return 1; }

        return n * factorial(n-1);
    }

    public int fibonacci(int n){ //-------------------------> M(n)

        if (n < 0 ) //-------------------------> O(1)
        { return -1; } //----------------------> O(1)
        if (n == 0 || n== 1) //----------------> O(1)
        { return n; } //-----------------------> O(1)

        return fibonacci(n-1) + factorial(n-2); //-------------------------> O(n-1) => M(n-1) => M(n) => O(n )
    }

    public int sumOfDigits(int n){

        //unintentional case
        if (n < 0){ return 0; }

        //base condition
        if (n ==0){ return 0; }

        return n%10 + sumOfDigits(n/10);
    }

    public int power(int base, int exp){

        if (exp <0){ return -1; }
        if (exp == 0 || exp ==1){ return base; }

        return base * power(base, exp-1);
    }

    public int gcd(int a, int b){

        if (a<0 || b<0) return -1;
        if ( b==0 ) return a;

        return gcd(b, a%b);
    }


    public int decimalToBinary(int n){

        if (n==0) return 0;

        return n%2 + 10* decimalToBinary(n/2);
    }

    public int productOfArray(int[] a, int n){

        if (n > a.length) return -1;
        if (n <= 0) return 1;
        return productOfArray(a, n-1) * a[n-1];
    }


    public int recursiveRange(int n){

        if (n <= 0) return 0;
        return n + recursiveRange(n-1);
    }
}
