package com.mosh;

public class ArraySpecialIndex {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int[] pfEven = generatePrefixEvenArray(arr);
        int[] pfOdd = generatePrefixOddArray(arr);

        int specialIndexCounter = 0;
        int N = arr.length;
        for(int i=0; i<N; i++){
            int totalEvenSum = 0;
            int totalOddSum = 0;

            if(i == 0){
                totalEvenSum = sumOfOdd(pfOdd, i+1, N-1);
                totalOddSum = sumOfEven(pfEven, i+1, N-1);
            }else if(i+1 == N){
                totalEvenSum = sumOfEven(pfEven, 0, i-1);
                totalOddSum = sumOfOdd(pfOdd, 0, i-1);
            }else{
                totalEvenSum = sumOfEven(pfEven, 0, i-1) + sumOfOdd(pfOdd, i+1, N-1);
                totalOddSum = sumOfOdd(pfOdd, 0, i-1) + sumOfEven(pfEven, i+1, N-1);
            }

            if(totalEvenSum == totalOddSum){
                specialIndexCounter++;
            }
        }

        System.out.println("The total number of special Indices are : "+ specialIndexCounter);
    }

    private static int[] generatePrefixEvenArray(int[] arr){
        int[] pfEven = new int[arr.length];

        pfEven[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            if(i % 2 == 1){
                pfEven[i] = pfEven[i-1];
            }else{
                pfEven[i] = pfEven[i-1] + arr[i];
            }
        }
        return pfEven;
    }

    private static int[] generatePrefixOddArray(int[] arr){
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
        return pfOdd;
    }

    private static int sumOfEven(int[] pfEven, int L, int R){
        if(L == 0){
            return pfEven[R];
        }
        return pfEven[R] - pfEven[L-1];
    }

    private static int sumOfOdd(int[] pfOdd, int L, int R){
        if(L == 0){
            return pfOdd[R];
        }
        return pfOdd[R] - pfOdd[L-1];
    }
}
