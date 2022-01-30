package com.mosh;

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion1 {
    public static void main(String[] args) {
        ArrayList<String> grayStrings = greyCode(3);
        ArrayList<Integer> codes = new ArrayList<>();

        for(String str : grayStrings){
            codes.add(Integer.parseInt(str, 2));
        }

        System.out.println(codes);
    }

    private static int sum(int N){
        if(N == 1){
            return 1;
        }
        return sum(N-1) + N;
    }

    private static int sumOfDigits(int N){
        if(N < 10){
            return N;
        }
        return sumOfDigits(N/10) + N % 10;
    }

    private static int isMagic(int N){
        int sum = sumOfDigits(N);
        int result = 0;
        System.out.println("sum : " + sum);

        if(sum > 9){
            result = isMagic(sum);
        }
        if(sum == 1){
            return 1;
        }
        return result;
    }

    private static int pow(int a, int N){
        if(N == 0){
            return 1;
        }
        return a * pow(a, N-1);
    }

    private static int powEfficient(int a, int n){
        if(n == 0) return 1;

        int halfPow = powEfficient(a, n/2);
        int halfAns = halfPow * halfPow;

        if(n % 2 == 0){
            return halfAns;
        }else{
            return a * halfAns;
        }
    }

    private static int largePower(int A, int B, int C){
        if(A == 0) return 0;
        if(B == 0) return 1;

        long halfPow = largePower(A, B/2, C);
        long halfAns = (((halfPow % C) * (halfPow % C)) % C);

        if(B % 2 == 0){
            return (int) (halfAns % C);
        }else{
            int aMod = (A % C);
            if(A < 0){
                aMod = A + C;
            }
            return (int) ((aMod * (halfAns % C)) % C);
        }
    }

    private static long fact(long N){
        if(N == 0){
            return 1;
        }
        return fact(N-1) * N;
    }

    private static int fibonacci(int N){
        if(N == 0 || N == 1){
            return 1;
        }
        return fibonacci(N-1) + fibonacci(N-2);
    }

    private static void printInc(int N){
        if(N == 1){
            System.out.println(1);
            return;
        }
        printInc(N-1);
        System.out.println(N);
    }

    private static void printDec(int N){
        if(N == 1){
            System.out.println(1);
            return;
        }
        System.out.println(N);
        printDec(N-1);
    }

    private static boolean isPalindrome(String str, int s , int e){
        if(s > e){
            return true;
        }
        if(str.charAt(s) == str.charAt(e)){
            return isPalindrome(str, s+1, e-1);
        }
        return false;
    }

    private static void printReverseString(String str, int index){
        if(index == 0){
            System.out.print(str.charAt(0));
            return;
        }

        System.out.print(str.charAt(index));
        printReverseString(str, index-1);
    }

    // Watch this video:
    // https://www.youtube.com/watch?v=QRa9ZVGMWlY&t=97s
    private static int kthSymbol(int A, int B){
        if(A == 1){
            return 0;
        }
        int parent = kthSymbol(A-1, (int) Math.ceil(B/2.0));
        boolean isBOdd = false;
        if(B % 2 == 1){
            isBOdd = true;
        }

        if(parent == 1){
            return isBOdd ? 1 : 0;
        }else{
            return isBOdd ? 0 : 1;
        }
    }

    // https://www.youtube.com/watch?v=KOD2BFauQbA
    private static ArrayList<String> greyCode(int n){
        if(n == 1){
            ArrayList<String> basecode = new ArrayList<>();
            basecode.add("0");
            basecode.add("1");
            return basecode;
        }

        ArrayList<String> result = greyCode(n-1);
        ArrayList<String> finalResult = new ArrayList<>();

        for(int i = 0; i < result.size(); i++){
            finalResult.add("0"+result.get(i));
        }

        for(int i = result.size()-1; i >= 0 ; i--){
            finalResult.add("1"+result.get(i));
        }

        System.out.println("Result : " + finalResult);
        return finalResult;
    }
}
