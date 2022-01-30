package com.mosh;

import java.util.Arrays;

public class ArraysHomeWork {

    public static void main(String[] args) {
        productArray();
    }

    private static void findSecondMaxofArray(){
        int[] A = {2, 2, 2};

        int firstMax = A[0];

        for(int i=1; i<A.length; i++){
            if(firstMax < A[i]){
                firstMax = A[i];
            }
        }

        System.out.println("First Max : " + firstMax);

        int secondMax = -1;
        int firstMaxCount = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] == firstMax){
                firstMaxCount++;
                continue;
            }
            if(secondMax < A[i]){
                secondMax = A[i];
            }
        }

        if(firstMaxCount > 1){
            secondMax = firstMax;
        }
        System.out.println("Second Max : " + secondMax);
    }

    private static int getDiffofMaxEvenNMinOdd(){
        int[] A = {5, 17, 100, 1};
        int maxEven = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
            if(A[i] % 2 == 0 ){
                if(maxEven < A[i]){
                    maxEven = A[i];
                }
            }else{
                if(A[i] < minOdd){
                    minOdd = A[i];
                }
            }

        }


        System.out.println("Max Even : " + maxEven);
        System.out.println("Min Odd : " + minOdd);
        System.out.println("Result : " + (maxEven - minOdd));
        return maxEven - minOdd;
    }

    private static void maxSumofB(){
        int[] A = {-969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587};
        int B = 81;

        long[] pf = new long[A.length];
        pf[0] = A[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
        }

        System.out.println("prefix sum : " + Arrays.toString(pf));

        long maxSum = Integer.MIN_VALUE;
        int N = A.length;
        for(int i=1; i<=B+1; i++){
            long currentSum = 0;
            if(i == B+1){
                currentSum = pf[N-1] - pf[N-i];
            }else{
                currentSum = pf[B-i] + (pf[N-1] - pf[N-i]);
            }
            if(maxSum < currentSum){
                maxSum = currentSum;
            }
        }

        System.out.println("Max Sum : " + (int)maxSum);
    }

    private static void sumFromLtoR(){
        int[] A = {2, 2, 2};
        int[][] B = {{1, 1}, {2, 3}};

        long[] pf = new long[A.length];
        pf[0] = A[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
        }

        long[] rangeSum = new long[B.length];

        for(int i=0; i<B.length; i++){
            rangeSum[i] = sumOfPrefix(pf, B[i][0]-1, B[i][1]-1);
            System.out.println(B[i][0] + " " + B[i][1]);
        }

        System.out.println("final result : " + Arrays.toString(rangeSum));

    }

    private static long sumOfPrefix(long[] pf, int L, int R){
        if(L <= 0){
            return pf[R];
        }
        return pf[R] - pf[L-1];
    }

    private static void totalTimeToMakeEqual(){
        int[] A = {1, 2, 3, 4, 5};
        int max = A[0];
        for(int i=1; i<A.length; i++){
            if(max < A[i]){
                max = A[i];
            }
        }

        int totalTime = 0;
        for(int i=0; i<A.length; i++){
            totalTime = totalTime + (max - A[i]);
        }

        System.out.println("Total time in Seconds: " + totalTime);
    }

    private static void productArray(){
        int[] A = {5, 1, 10, 1};
        int totalProduct = A[0];

        for(int i=1; i<A.length; i++){
            totalProduct *= A[i];
        }

        int[] result = new int[A.length];

        for(int i=0; i<A.length; i++){
            result[i] = totalProduct / A[i];
        }

        System.out.println(Arrays.toString(result));
    }
}
