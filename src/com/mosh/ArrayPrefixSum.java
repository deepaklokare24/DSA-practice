package com.mosh;

import java.util.Arrays;

public class ArrayPrefixSum {
    public static void main(String[] args) {

        sumOfAllOddIndicesOfaRange();

    }

    private static void noOfEquilibriumIndices() {
        int[] arr = {3, -1, 2, -1, 1, 2, 1};
        int[] pf = new int[arr.length];

        pf[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pf[i] = pf[i-1] + arr[i];
        }

        int left = 0;
        int right = 0;
        int equilibriumCounter = 0;
        for(int i=0; i<arr.length; i++){
            if(i == 0){
                left = 0;
            }else{
                left = pf[i-1];
            }
            right = pf[arr.length -1] - pf[i];

            if(left == right){
                equilibriumCounter++;
            }
        }

        System.out.println("The total no of Equilibrium Indexes are: " + equilibriumCounter);
    }

    private static void sumOfElementsUsingPrefixArray() {
        int[] arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        int[] pf = new int[arr.length];

        pf[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pf[i] = pf[i-1] + arr[i];
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(pf));
        int L = 0;
        int R = 4;
        int result = 0;

        if(L == 0){
            result = pf[R];
        }else{
            result = pf[R] - pf[L-1];
        }

        System.out.println("Sum of elements betwenn " + L + " and " + R + " = " + result);
    }

    private static void getSumOfArrayWithinGivenRange() {
        int[] arr = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        int L = 0;
        int R = 4;
        int sum = 0;
        for(int i=L; i<=R; i++){
            sum = sum + arr[i];
        }
        System.out.println("Sum : " + sum);
    }

    private static void sumOfAllEvenIndicesOfaRange(){
        int[] arr = {3, 4, -2, 8, 6, 2, 1, 3};
        int[] pfEven = new int[arr.length];

        pfEven[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            if(i % 2 == 1){
                pfEven[i] = pfEven[i-1];
            }else{
                pfEven[i] = pfEven[i-1] + arr[i];
            }
        }

        System.out.println("PfEven array : " + Arrays.toString(pfEven));

        int L=3, R=7;
        int result = pfEven[7] - pfEven[2];
        System.out.println("Result : " + result);
    }

    private static void sumOfAllOddIndicesOfaRange(){
        int[] arr = {3, 4, -2, 8, 6, 2, 1, 3};
        int[] pfOdd = new int[arr.length];

        pfOdd[0] = 0;
        pfOdd[1] = arr[1];
        for(int i=2; i<arr.length; i++){
            if(i % 2 == 0){
                pfOdd[i] = pfOdd[i-1];
            }else{
                pfOdd[i] = pfOdd[i-1] + arr[i];
            }
        }

        System.out.println("PfEven array : " + Arrays.toString(pfOdd));

        int L=3, R=7;
        int result = pfOdd[7] - pfOdd[2];
        System.out.println("Result : " + result);
    }
}
