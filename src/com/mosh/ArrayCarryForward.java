package com.mosh;

import java.util.Arrays;
import java.util.Locale;

public class ArrayCarryForward {
    public static void main(String[] args) {
        lightBulbSwitchCarryForward();
    }

    private static void countPairsOfAGBruteForce(){
        String input = "adgagagfg";
        int count = 0;

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                for(int j=i+1; j<input.length(); j++){
                    if(input.charAt(j) == 'g'){
                        count++;
                    }
                }
            }
        }

        System.out.println("Total no. of pairs : " + count);
    }

    private static void countPairsOfAGCarryForward(){
        String input = "baagdcag";
        int gCount = 0;
        int result = 0;

        for(int i=input.length()-1; i>=0; i--){
            if(input.charAt(i) == 'g'){
                gCount++;
            }else if(input.charAt(i) == 'a'){
                result += gCount;
            }
        }

        System.out.println((int)(result % (Math.pow(10, 9)+7)));

        System.out.println("Total no. of pairs using carryForward : " + result);
    }

    private static void countPairsOfAGCarryForwardA(){
        String input = "adgagagfg";
        int aCount = 0;
        int result = 0;

        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == 'a'){
                aCount++;
            }else if(input.charAt(i) == 'g'){
                result += aCount;
            }
        }

        System.out.println("Total no. of pairs using carryForward : " + result);
    }

    private static void leadersInArray(){
        int[] arr = {10, 8, 8};
        int N = arr.length;
        int leader = arr[N -1];
        int count = 1;
        for(int i=N-2; i>=0; i--){
            if(leader < arr[i]){
                leader = arr[i];
                count++;
            }
        }
        System.out.println("Total Number of Leaders : " + count);
    }

    private static void findSmallestSubArrayBruteForce(){
        int[] arr = {1, 6, 4, 2, 7, 7, 5, 1, 3, 1, 1, 5};
        int N = arr.length;
        int ans = N;
        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<N; i++){
            if(max < arr[i]){
                max = arr[i];
            }else if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println("min : " + min + " max : " + max);

        for(int i=0; i<N; i++){
            if(arr[i] == min){
                for(int j=i; j<N; j++){
                    if(arr[j] == max){
                        ans = Math.min(ans, j-i+1);
                        break;
                    }
                }
            }else if(arr[i] == max){
                for(int j=i; j<N; j++){
                    if(arr[j] == min){
                        ans = Math.min(ans, j-i+1);
                        break;
                    }
                }
            }
        }

        System.out.println("Length of smallest Sub array : " + ans);
    }

    private static void findSmallestSubArrayCarryForward(){
        int[] arr = {2};
        int N = arr.length;

        int min = arr[0];
        int max = arr[0];

        for(int i=1; i<N; i++){
            if(max < arr[i]){
                max = arr[i];
            }else if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println("min : " + min + " max : " + max);
        int ans = N;
        int minIndex = -1;
        int maxIndex = -1;

        if(min == max){
            ans = 1;
        }else{
            for(int i=N-1; i>=0; i--){
                if(arr[i] == min){
                    minIndex = i;
                    if(maxIndex != -1){
                        ans = Math.min(ans, maxIndex-minIndex+1);
                    }
                }else if(arr[i] == max){
                    maxIndex = i;
                    if(minIndex != -1){
                        ans = Math.min(ans, minIndex-maxIndex+1);
                    }
                }
            }
        }

        System.out.println("Length of smallest Sub array : " + ans);
    }

    private static void amazingSubArray(){
        String A = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn".toLowerCase();

        int counter = 0;
        int sum = 0;
        int N= A.length();
        for(int i=N-1; i>=0; i--){
            counter++;
            if(isVowel(A.charAt(i))){
                sum += counter;
            }
        }

        System.out.println("No of Amazing substrings: " + sum % 10003);
    }

    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }

    private static void lightBulbSwitchBruteForce(){
        int[] A = {0, 1, 0, 1};
        int counter = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == 0){
                A[i] = 1;
                counter++;
                for(int j=i+1; j<A.length; j++){
                    A[j] = (A[j] == 1) ? 0 : 1;
                }
            }
        }

        System.out.println("Minimum no of switches required: "+ counter);

    }

    private static void lightBulbSwitchCarryForward(){
        int[] A = {1, 1, 1, 1};
        int counter = 0;
        if(A[0] == 0){
            counter++;
        }

        for(int i=1; i<A.length; i++){
            if(A[i] != A[i-1]){
                counter++;
            }
        }

        System.out.println("Minimum no of switches required: "+ counter);

    }
}
