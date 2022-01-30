package com.mosh;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysInterveiwQs {
    public static void main(String[] args) {
        printHallowDiamondStarPattern();
    }

    private static void productOfAllelementsExceptItself(){
        int[] arr = {3, 4, 6, 9, 2};
        int N = arr.length;
        int[] result = new int[N];

        int[] prefixProduct = new int[arr.length];
        prefixProduct[0] = arr[0];
        for(int i=1; i<N; i++){
            prefixProduct[i] = prefixProduct[i-1] * arr[i];
        }
        System.out.println("Prefix Product : " + Arrays.toString(prefixProduct));

        int[] suffixProduct = new int[arr.length];
        suffixProduct[N-1] = arr[N-1];
        for(int i=N-2; i>=0; i--){
            suffixProduct[i] = suffixProduct[i+1] * arr[i];
        }
        System.out.println("Suffix Product : " + Arrays.toString(suffixProduct));


        for(int i=0; i<N; i++){
            if(i==0){
                result[0] = 1 * suffixProduct[i+1];
            }else if(i==N-1){
                result[i] = prefixProduct[i-1] * 1;
            }else{
                result[i] = prefixProduct[i-1] * suffixProduct[i+1];
            }
        }

        System.out.println("Final Result : " + Arrays.toString(result));
    }

    private static void maxConsecutiveOnesBruteForce(){
        int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0};

        int N = arr.length;

        int leftCounter = 0;
        int rightCounter = 0;
        int totalCount = 0;
        int maxTotal = 0;

        int noOfOnes = 0;
        for(int i=0; i<N; i++){
            if(arr[i] == 1){
                noOfOnes++;
            }
        }

        if(noOfOnes == N){
            maxTotal = N;
        }else{
            for(int i=0; i<N; i++){
                if(arr[i] == 0){
                    leftCounter = 0;
                    for(int j=i-1; j>=0; j--){
                        if(arr[j] == 1){
                            leftCounter++;
                        }else{
                            break;
                        }
                    }
                    rightCounter = 0;
                    for(int j=i+1; j<N; j++){
                        if(arr[j] == 1){
                            rightCounter++;
                        }else{
                            break;
                        }
                    }
                    totalCount = leftCounter + rightCounter + 1;
                    maxTotal = Math.max(totalCount, maxTotal);
                }
            }
        }
        System.out.println(maxTotal);
    }

    private static void maxConsecutiveOnesCarryForward(){
        //int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0};
        //int[] arr = {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        int[] arr = {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1};

        int N = arr.length;

        int leftCounter = 0;
        int rightCounter = 0;
        int totalCount = 0;
        int maxTotal = 0;

        for(int i=0; i<N; i++){
            if(arr[i] == 0){
                totalCount = leftCounter + rightCounter + 1;
                maxTotal = Math.max(maxTotal, totalCount);
                leftCounter = rightCounter;
                rightCounter = 0;
            }else{
                rightCounter++;
            }
        }
        System.out.println(maxTotal);
    }

    private static void maxConsecutiveOnesCarryForward_Swap(){
        //int[] arr = {0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0};
        //int[] arr = {1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0};
        String arr = "010100110101";

        int N = arr.length();

        int leftCounter = 0;
        int rightCounter = 0;
        int totalCount = 0;
        int maxTotal = 0;

        int noOfOnes = 0;
        for(int i=0; i<N; i++){
            if(arr.charAt(i) == '1'){
                noOfOnes++;
            }
        }

        if(noOfOnes == N){
            maxTotal = N;
        }else{
            for(int i=0; i<N; i++){
                if(arr.charAt(i) == '0'){
                    leftCounter = 0;
                    for(int j=i-1; j>=0; j--){
                        if(arr.charAt(j) == '1'){
                            leftCounter++;
                        }else{
                            break;
                        }
                    }
                    rightCounter = 0;
                    for(int j=i+1; j<N; j++){
                        if(arr.charAt(j) == '1'){
                            rightCounter++;
                        }else{
                            break;
                        }
                    }
                    totalCount = leftCounter + rightCounter + 1;
                    maxTotal = Math.max(totalCount, maxTotal);
                }
            }
        }

        System.out.println(maxTotal);
    }

    private static void minimumCostOfChristmasTrees(){
        int[] A = {5, 9, 10, 4, 7, 8};
        int[] B = {5, 6, 4, 7, 2, 5};
        int N = A.length;

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<N-1; i++){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;

            for(int j=i-1; j>=0; j--){
                if(A[i] > A[j]){
                    min1 = Math.min(min1, B[j]);
                }
            }

            for(int j=i+1; j<N; j++){
                if(A[i] < A[j]){
                    min2 = Math.min(min2, B[j]);
                }
            }

            if(min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE){
                ans = Math.min(ans, min1+B[i]+min2);
            }
        }


        System.out.println("Minimum cost of trees : "+ ans);
    }

    private static void countNoOfTriplets(){
        int[] arr = {5, 9, 10, 4, 7, 8};
        int N = arr.length;
        int totalCount = 0;

        for(int i=1; i<N-1; i++){
            int left = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i] > arr[j]){
                    left++;
                }
            }
            int right = 0;
            for(int j=i+1; j<N; j++){
                if(arr[i] < arr[j]){
                    right++;
                }
            }
            totalCount += left * right;
        }
        System.out.println("Total no. of Triplets are : "+ totalCount);
    }

    private static void findMaximumPositivitySubArray(){
        int[] A = {1, 2, -3, 4, 5, -6, 7, 8, 9, -10, 11};
        int N = A.length;
        int sIndex = 0;
        int eIndex = 0;
        int subArraySize = 0;

        int si = 0;
        int ei = 0;
        for(int i=0; i<N; i++){
            if(A[i] > 0){
                eIndex++;
            }else{
                break;
            }
        }
        ei = eIndex-1;
        subArraySize = ei - si + 1;
        System.out.println(sIndex + " - " + (eIndex-1) + " Size : " + subArraySize);
        int maxSize = subArraySize;

        for(int i=eIndex; i<N; i++){
            if(A[i] < 0){
                for(int j=i+1; j<N; j++){
                    if(A[j] > 0){
                        eIndex = j;
                    }else{
                        break;
                    }
                }
                sIndex = i+1;
                subArraySize = eIndex-sIndex+1;

                System.out.println(sIndex + " - " + eIndex + " Size : " + subArraySize);
                if(maxSize < subArraySize){
                    maxSize = subArraySize;
                    si = sIndex;
                    ei = eIndex;
                }
            }
        }

        System.out.println(" Final Subarray with sIndex: " + si + " eIndex: " + ei + " size : " + maxSize);
        int[] result = new int[maxSize];
        int i = si;
        int j = 0;
        while(j<maxSize){
            result[j] = A[i];
            j++;
            i++;
        }

        System.out.println("Output: " + Arrays.toString(result));
    }

    private static void printHallowDiamondStarPattern(){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = N;
        int total = N+N;

        while(M>0){
            for(int i=0; i<M; i++){
                System.out.print("*");
            }
            for(int i=0; i<total-(M+M); i++){
                System.out.print(" ");
            }
            for(int i=0; i<M; i++){
                System.out.print("*");
            }
            System.out.println();
            M--;
        }

        M = 1;
        while(M<=N){
            for(int i=0; i<M; i++){
                System.out.print("*");
            }
            for(int i=0; i<total-(M+M); i++){
                System.out.print(" ");
            }
            for(int i=0; i<M; i++){
                System.out.print("*");
            }
            System.out.println();
            M++;
        }

    }

}
