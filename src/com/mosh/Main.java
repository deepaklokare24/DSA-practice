package com.mosh;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ///Scanner scanner = new Scanner(System.in);

        rotateArrayAntiClockWiseByKTimes();
    }

    private static void findMaxAndMin(){
        int[] arr = {4, 10, 50, 40, 80};
        int max = arr[0];
        int min = arr[0];

        for(int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }else if(min > arr[i]){
                min = arr[i];
            }
        }

        System.out.println(max + "  " + min);
    }

    private static void noOfElementsGreaterThanItself(){
        int[] arr = {2, 5, 1, 4, 8, 0, 8, 1, 3, 8};
        int max = arr[0];
        int countMax = 1;
        for(int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }else if(max == arr[i]){
                countMax += 1;
            }
        }
        System.out.println("Max element : " + max + " and its count is : " + countMax);
        System.out.println("No of elements having at least 1 element greater than itself are: " + (arr.length - countMax));
    }

    private static int[] reverseArray(int[] arr){
        //int[] arr = {3, -2, 1, 4, 3, 6, 8};
        for(int i=0, j=arr.length-1; i<arr.length/2; i++, j--){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
        return arr;
    }

    private static int[] reverseBySiEi(int[] arr, int si, int ei){
        /*int[] arr = {-3, 4, 2, 8, 7, 9, 6, 2};
        int si = 3;
        int ei = 7;*/

        int i = si, j = ei;

        while(i<j){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
        return arr;
        //System.out.println(Arrays.toString(arr));
    }

    private static boolean checkPairs(){
        int[] arr = {3, -2, 1, 4, 3, 6, 8};
        int k=10;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i] + arr[j] == k){
                    return true;
                }
            }
        }

        return false;
    }

    private static void rotateArrayClockWiseByKTimes() {
        int[] arr = {-2, 3, 1, 4, 6, 2, 8, 7, 9, 3};
        int k = 3;

        if(k > arr.length) k = k % arr.length;
        System.out.println(" << Before Rotate >> ");
        System.out.println(Arrays.toString(arr));
        reverseArray(arr);

        System.out.println(" << After Reverse >>");
        System.out.println(Arrays.toString(arr));

        reverseBySiEi(arr,0, k-1);
        reverseBySiEi(arr, k, arr.length-1);

        System.out.println(" *** After Rotate ***");

        for(int i=0; i<arr.length; i++){

            System.out.print(arr[i] + " ");
        }
    }

    private static void rotateArrayAntiClockWiseByKTimes() {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3, 4, 3};
        int[][] result = new int[B.length][A.length];

        for(int i=0; i<B.length; i++){
            int[] copy = new int[A.length];
            System.arraycopy(A, 0, copy, 0, A.length);
            int bValue = B[i];
            if(bValue > A.length) bValue = bValue % A.length;
            int k = A.length - bValue;

            reverseBySiEi(copy, 0, A.length-1);
            reverseBySiEi(copy,0, k-1);
            reverseBySiEi(copy, k, A.length-1);

            result[i] = copy;
        }

        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.toString(A));
    }
}
