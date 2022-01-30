package com.mosh;

public class ArraySubarrays {
    public static void main(String[] args) {
        printAllSubarrays();
    }

    private static void printAllSubarrays(){
        int[] arr = {1, 2, 3, 4};

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                printRange(arr, i, j);
            }
        }
    }

    private static void printRange(int[] arr, int i, int j){
        for(int k=i; k<=j; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    private static boolean isPrime(int N){
        int c = 0;

        for(int i=1; i*i <= N; i++){
            if(N % i == 0){
                if(i == N/i){
                    c = c + 1;
                }else{
                    c = c + 2;
                }
            }
        }

        if(c == 2){
            return true;
        }

        return  false;
    }


    private static void printAllIndeciesOfSubarraysOfLengthK(){
        int[] arr = {3, 4, 2, -1, 6, 7, 8, 9, 3, 2, -1, 4};
        int N = arr.length;
        int k = 6;

        for(int s=0, e=k-1; s<=N-k; s++, e++){
            System.out.println("[ "+ s + " , " + e + " ]");
        }

        System.out.println("So Total there are : " + (N-k+1) + " Sub arrays of length K = "+k );
    }

    private static void findMaxSubarraySumoflengthKBruteForce(){
        int[] arr = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int N = arr.length;
        int k = 5;
        int maxSum = Integer.MIN_VALUE;

        for(int s=0, e=k-1; s<=N-k; s++, e++){
            int sum = 0;
            for(int i=s; i<=e; i++){
                sum += arr[i];
            }
            if(sum > maxSum){
                maxSum = sum;
            }
        }

        System.out.println("Max Sum : " + maxSum);
    }

    private static void findMaxSubarraySumoflengthKUsingPrefixSum(){
        int[] arr = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int N = arr.length;
        int[] pf = new int[N];
        int k = 6;
        int maxSum = Integer.MIN_VALUE;

        pf[0] = arr[0];
        for(int i=1; i<N; i++){
            pf[i] = pf[i-1] + arr[i];
        }

        for(int s=0, e=k-1; s<=N-k; s++, e++){
            int sum = 0;
            if(s == 0){
                sum = pf[e];
            }else{
                sum = pf[e] - pf[s-1];
            }
            System.out.print(sum + " ");

            if(sum > maxSum){
                maxSum = sum;
            }
        }

        System.out.println("Max Sum : " + maxSum);
    }

    private static void findMaxSubarraySumoflengthKUsingSlidingWindow(){
        int[] arr = {-3, 4, -2, 5, 3, -2, 8, 2, -1, 4};
        int N = arr.length;
        int k = 6;

        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int maxSum = sum;

        for(int s=1, e=k; s<=N-k; s++, e++){
            sum = sum - arr[s-1] + arr[e];
            if(sum > maxSum){
                maxSum = sum;
            }
        }

        System.out.println("Max sum : " + maxSum);
    }

    private static void printAllSubArraySumsUsingPrefixSum(){
        int[] arr = {2, 1, 3, 4, 5};
        int N = arr.length;
        int[] pf = new int[N];

        pf[0] = arr[0];
        for(int i=1; i<N; i++){
            pf[i] = pf[i-1] + arr[i];
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                if(i==0){
                    System.out.print(pf[j] + " ");
                    sum += pf[j];
                }else {
                    System.out.print((pf[j] - pf[i-1]) + " ");
                    sum += (pf[j] - pf[i-1]);
                    maxSum = Math.max(sum, maxSum);
                }
            }
            System.out.println();
        }

        System.out.println("total sum : " + sum);
        System.out.println("Max sum : " + maxSum);
    }

    private static void printAllSubArraySumsUsingCarryForward(){
        int[] arr = {2, 1, 3, 4, 5};
        int N = arr.length;
        int maxSum = arr[0];
        int totalSum = 0;

        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N; j++){
               sum = sum + arr[j];
               System.out.print(sum + " ");
               maxSum = Math.max(sum, maxSum);
               totalSum += sum;
            }
            System.out.println();
        }

        System.out.println("Max Sum : " + maxSum);
        System.out.println("Total Sum : " + totalSum);
    }

    private static void findSumOfAllSubArraysUsingContributionTecnique(){
        int[] arr = {2, 1, 3};
        int N = arr.length;
        long totalSum = 0;

        for(int i=1, j=N; i<=N; i++, j--){
            int left = i;
            int right = j;
            totalSum += left * right * arr[i-1];
        }
        System.out.println("total sum : " + totalSum);
    }

    private static void findMaxSubarrayAverageoflengthKUsingSlidingWindow(){
        int[] arr = {20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        int N = arr.length;
        int k = 9;

        double sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        double minAverage = sum/k;
        int index = 0;
        System.out.println(sum + " " + minAverage);

        for(int s=1, e=k; s<=N-k; s++, e++){
            sum = sum - arr[s-1] + arr[e];
            double avg = sum/k;
            if(minAverage > avg){
                minAverage = avg;
                index = s;
            }
            System.out.println(sum + " " + avg);
        }

        System.out.println("Max Average : " + minAverage + " with index : " + index);
    }

    private static void findMaxSubArraySum(){
        int[] arr = {2, 2, 2};
        int N = arr.length;
        long maxSum = Long.MIN_VALUE;
        boolean hasEntered = false;
        long B = 1;

        for(int i=0; i<N; i++){
            long sum = 0;
            for(int j=i; j<N; j++){
                sum = sum + arr[j];
                System.out.print(sum + " ");
                if(maxSum < sum && sum <= B){
                    hasEntered = true;
                    maxSum = sum;
                }
            }
            System.out.println();
        }

        System.out.println("Max Sum : " + (hasEntered ? maxSum : 0));
    }

    private static void numberOfSubarrysHavingSumLessThanB(){
        int[] arr = {1, 11, 2, 3, 15};
        int N = arr.length;
        long B = 10;
        int counter = 0;
        for(int i=0; i<N; i++){
            long sum = 0;
            for(int j=i; j<N; j++){
                sum = sum + arr[j];
                if(sum < B){
                    counter++;
                }
            }
        }
        System.out.println("Total number of SubArrays in A having sum less than B are : " + counter);
    }

    private static void numberOfGoodSubarrys(){
        int[] arr = {13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9};
        int N = arr.length;
        long B = 65;
        int counter = 0;
        for(int i=0; i<N; i++){
            long sum = 0;
            for(int j=i; j<N; j++){
                int length = (j-i+1);
                sum = sum + arr[j];
                if(length % 2 == 0 && sum < B){
                    counter++;
                }else if(length % 2 == 1 && sum > B ){
                    counter++;
                }
            }
        }
        System.out.println("Total number of Good SubArrays are: " + counter);
    }

    private static void alternatingSubArraysofZerosNonces(){
        int[] arr = {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1};
        int N = arr.length;
        int B = 1;
        int k = 2*B + 1;


        for(int s=0, e=k-1; s<=N-k; s++, e++){
            boolean isAlternative = true;
            for(int i=s; i<e; i++){
                if(arr[i] == arr[i+1]){
                    isAlternative = false;
                    break;
                }
            }

            if(isAlternative){
                System.out.println("Index : " + (s+e)/2);
            }
        }
        //System.out.println("IS alternative : " + isAlternative);
    }
}
