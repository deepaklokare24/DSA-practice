package com.mosh;

import java.util.ArrayList;
import java.util.Arrays;

public class BitManipulation1 {
    public static void main(String[] args) {
        maximumSatisfaction();
    }

    private static void findSingleNumber(){
        int[] A = {1, 2, 2, 3, 1};
        int result = 1;

        for(int i=1; i<A.length; i++){
            result = result ^ A[i];
            System.out.println(result);
        }
    }

    private static void addBinaryStrings(){
        String A = "10001100010111000101100010100110001001101010000010011010";
        String B = "101111000100100100111110010010101110101001100100101001111010011000000110";

        long a = convertStringToBinary(A);
        long b = convertStringToBinary(B);
        long result = a + b;

        System.out.println(a);
        System.out.println(b);
        System.out.println(result);

        System.out.println(Long.toBinaryString(result));


    }

    private static long convertStringToBinary(String A){
        long sum = 0;
        for(int i=A.length()-1, j=0; i>=0; i--, j++){
            if(A.charAt(j) == '1'){
                sum = (long) (sum + Math.pow(2, i));
            }
        }
        return sum;
    }

    private static void interestingArray(){
        int[] A = {1};
        int result = A[0];

        for(int i=1; i<A.length; i++){
            result = result ^ A[i];
        }

        if(result > 1 && result % 2 == 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        System.out.println(result);
    }

    private static void isIthBitOn(){
        int a = 35;
        int i = 3;

        System.out.println(Integer.toBinaryString(a));
//        Solution: 1
        String result = (a >> i) % 2 == 0 ? "OFF" : "ON";
        System.out.println(result);
//        Solution: 2

        a = 35;
        result = (a & (1 << i)) == 0 ? "OFF" : "ON";
        System.out.println(result);
    }

    private static void setABit(){
        int a = 35;
        int i = 3;

        System.out.println(Integer.toBinaryString(a));
        a = a | (1 << i);
        System.out.println(Integer.toBinaryString(a));
    }

    private static void unSetABit(){
        int a = 43;
        int i = 3;

        System.out.println(Integer.toBinaryString(a));
        a = a & (~(1 << i));
        System.out.println(Integer.toBinaryString(a));
    }

    private static void tellTheNumberhasOnlySingleBitSwitchedON(){
        int a = 35;

//        Solution: 1
        int counter = 0;
        for(int i=0; i<32; i++){
            if((a & (1 << i)) != 0){
                counter++;
            }
        }

        if(counter == 1){
            System.out.println("It has single bit turned on");
        }else{
            System.out.println("It has more than one bit: " + counter + " Switched on!");
        }

//        Simplest Solution

        a = 1024;
       String result = ( a & (a - 1) ) == 0 ? "Single bit on" : "More than one bit is on";
        System.out.println(result);
    }

    private static void countTheNoofSetBits(){
        int a = 63;
        int counter = 0;
        String binaryRep = Integer.toBinaryString(a);
        System.out.println(binaryRep);
        for(int i=0; i<binaryRep.length(); i++){
            if(a % 2 == 1){
                counter++;
            }
            a = a >> 1;
        }
        System.out.println("No of Set bits; " + counter);
    }

    private static void findOuttheMissingNumber(){
        int[] A = {5, 4, 1, 2};
        System.out.println(1^2^3^4^5^5^4^1^2);

        int intermidiateResult = A[0];
        for(int i=1; i<A.length; i++){
            intermidiateResult = intermidiateResult ^ A[i];
        }

        for(int i=1; i<= A.length+1; i++){
            intermidiateResult = intermidiateResult ^ i;
        }

        System.out.println("Final Result : "+ intermidiateResult);
    }

    private static void reverseABinaryNumber(){
        long a = 3;
        System.out.println(Long.toBinaryString(a));
        long result = 0;
        for(int i=0; i<64; i++){
            if((a & (1 << i)) != 0){
                System.out.println(Long.toBinaryString(result));
                result = result | (1 << (63-i));
            }
        }
    }

    private static void findTwoElementsAppearOnlyOnce(){
        int[] A = {1, 3, 5};

        int xor = A[0];

        for(int i=1; i<A.length; i++){
            xor = xor ^ A[i];
        }


        //System.out.println(20 ^ 15 ^ 4 ^ 14);
    }

    private static void maximumSatisfaction(){
        int[] A = {1, 18, 15, 16, 7, 127, 3, 83, 31, 23, 31};
        //int[] A = {10, 20, 15, 4, 14};

        int max = A[0];
        for(int i=1; i<A.length; i++){
            max = Math.max(A[i], max);
        }

        int N = Integer.toBinaryString(max).length();
        int ans = 0;
        for(int k = N-1; k >=0; k--){
            int countOfOnes = 0;
            for(int i=0; i<A.length; i++){
                if((A[i] & (1 << k)) != 0){
                    countOfOnes++;
                }
            }
            if(countOfOnes >= 4){
                System.out.println((1 << k ) + " > " + Math.pow(2, k));
                ans = (int) (ans + Math.pow(2, k));
                for(int i=0; i<A.length; i++){
                    if((A[i] & (1 << k)) == 0){
                        A[i] = 0;
                    }
                }
            }
        }

        System.out.println(ans);

    }

    private static void maximumSatisfaction2(){
//        int[] A = {10, 20, 15, 4, 14};
        int[] A = {1, 18, 15, 16, 7, 127, 3, 83, 31, 23, 31};

        System.out.println(15 & 127 & 31 & 31);
    }

}
