package com.mosh;

import java.util.Arrays;
import java.util.List;

public class Puzzels {
    public static void main(String[] args) {
        nthMagicalNumber();
    }

    private static void josephusProblem(){
        int N = 100;
        int x = 1;
        for(int i=0; i<N; i++){
            if(Math.pow(2, i) <= N){
                x = i;
            }
        }

        int noOfKills = N - (int)Math.pow(2, x);
        int lastPerson = 1 + 2 * noOfKills;

        System.out.println(lastPerson);
    }

    private static void majorityElement(){
        int[] A = {1};
        int N = A.length;
        int element = A[0];
        int freq = 1;

        for(int i=1; i<N; i++){
            if(freq == 0){
                element = A[i];
                freq = 1;
            }else if(element == A[i]){
                freq++;
            }else{
                freq--;
            }
        }

        System.out.println(element);

        //Check if element is majority or not

        int count = 0;
        for(int i=0; i<N; i++){
            if(A[i] == element){
                count++;
            }
        }

        //Check if the count is greater than N/2
        if(count > (int)Math.floor(N/2)){
            System.out.println("Majority Element is : " + element);
        }else{
            System.out.println("There is no Majority Element!");
        }
    }

    private static void majority3Element(){
        int[] A = {1};
        int N = A.length;

        Arrays.sort(A);
        int element = A[0];
        int freq = 1;

        for(int i=1; i<N; i++){
            if(A[i] == A[i-1]){
                freq++;
            }else {
                freq = 1;
            }
            if(freq > N/3){
                System.out.println("Majority element : " + A[i] + " with freq: " + freq);
                break;
            }
        }
    }

    private static void countTheNumberOfOddFactorsBetween1ToN(){
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int countOfOddFactors = 0;

        System.out.println("ans : " + countOfOddFactors);
    }

    private static int countTheNoOfFactors(int N){
        int count = 0;

        for(int i=1; i <= N; i++){
            if(N % i == 0){
                count++;
            }
        }
        System.out.println("The no of factors for : " + N + " is : " + count);
        return  count;
    }

    private static void nthMagicalNumber(){
        int N = 9;
        int ans = 0;
        for(int i=0; i<32; i++){
            if((N & (1 << i)) != 0){
                ans += Math.pow(5, i+1);
            }
        }
        System.out.println(ans);
    }


}
