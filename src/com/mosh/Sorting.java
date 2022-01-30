package com.mosh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
    public static void main(String[] args) {
        littlePonnyMaximumElementWithArraylist();
    }

    private static void minCostToRemoveAllElements(){
        int[] A = {3, 5, 1, -3};
        Arrays.sort(A);

        int[] pf = new int[A.length];
        pf[0] = A[0];

        int sum = pf[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
            sum += pf[i];
        }

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(pf));
        System.out.println("Minimum cost: " + sum);
    }

    private static void minCostToRemoveAllElementsSimplified(){
        Integer[] A = {3, 5, 1, -3};
        Arrays.sort(A, Collections.reverseOrder());
        int sum = 0;

        for(int i=0; i<A.length; i++){
            sum = sum + A[i] * (i+1);
        }
        System.out.println(sum);
    }

    private static void NobleIntegerPart1BruteForce(){
        int[] A = {-10, -5, 1, 3, 4, 5, 10};
        Arrays.sort(A);

        int ansCount = 0;

        for(int i=0; i<A.length; i++){
            int lessCount = 0;
            for(int j=0; j<A.length; j++){
                if(A[j] < A[i]){
                    lessCount++;
                }
            }
            if(lessCount == A[i]){
                ansCount++;
            }
        }
        System.out.println("Total Number of Nobel Integers: " + ansCount);
    }

    private static void NobleIntegerPart1Simplified(){
        int[] A = {-10, -5, 1, 3, 4, 5, 10};
        Arrays.sort(A);

        int ansCount = 0;

        for (int i=0; i<A.length; i++){
            if(A[i] == i){
                ansCount++;
            }
        }
        System.out.println("Total Number of Nobel Integers: " + ansCount);
    }

    private static void NobleIntegerPart2LesserThan(){
        int[] A = {-10, 1, 1, 1, 4, 4, 4, 7, 10};

        int ansCount = 0;
        int lessCount = 0;

        if(A[0] == 0){
            ansCount++;
        }

        for(int i=1; i<A.length; i++){
            if(A[i] != A[i-1]){
                lessCount = i;
            }
            if(lessCount == A[i]){
                ansCount++;
            }
        }

        System.out.println("Total Number of Nobel Integers: " + ansCount);
    }

    private static void NobleIntegerPart2GreaterThan(){
        int[] A = {3, 2, 1 ,3};
        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());
        int ansCount = 0;
        int greaterCount = 0;
        /*int maxElement = A[0];

        for(int i=1; i<A.length; i++){
            if(maxElement < A[i]){
                maxElement = A[i];
            }
        }

        if(A[0] == maxElement){
            ansCount++;
        }*/

        for(int i=1; i<A.length; i++){
            if(arr[i] != arr[i-1]){
                greaterCount = i;
            }
            if(greaterCount == arr[i]){
                ansCount++;
            }
        }

        System.out.println("Total Number of Nobel Integers: " + ansCount);
    }

    private static int factorOfN(int N){
        int count = 0;
        for(int i=1; i<=N; i++){
            if(N % i == 0){
                count++;
            }
        }
//        System.out.println("Factors of N : " + N + " are = " + count);
        return count;
    }

    private static void sortByNoofFactors(){
        Integer[] A = {1, 21, 6, 23, 10, 14, 25};

        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer f1 = factorOfN(o1);
                Integer f2 = factorOfN(o2);

                Integer result = 0;
                if(f1 < f2){
                    result = -1;
                }else if (f1 > f2){
                    result = 1;
                }else if(f1 == f2 && o1 < o2){
                    result = -1;
                }else if(f1 == f2 && o1 > o2){
                    result = 1;
                }
                return result;
            }
        });

        System.out.println(Arrays.toString(A));
    }

    private static void sortByNoofDigits(){
        Integer[] A = {93, 2, 37, 639, 8, 100, 345, 49};

        Arrays.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer l1 = Integer.toString(o1).length();
                Integer l2 = Integer.toString(o2).length();

                Integer result = 0;
                if(l1 < l2){
                    result = -1;
                }else if (l1 > l2){
                    result = 1;
                }else if(l1 == l2 && o2 < o1){
                    result = -1;
                }else if(l1 == l2 && o2 > o1){
                    result = 1;
                }
                return result;
            }
        });

        System.out.println(Arrays.toString(A));
    }

    private static void checkArithmeticProgression(){
        int[] A = {2, 4, 1};

        Arrays.sort(A);
        int diff = A[1] - A[0];
        boolean isAP = true;
        for(int i=2; i<A.length; i++){
            if(A[i] - A[i-1] != diff){
                isAP = false;
                break;
            }
        }

        System.out.println("IS AP : " + isAP);
    }

    private static void littlePonyMobiles(){
//        let A = [3, 4, 4, 6];
//        let B = [20, 4, 10, 2];
//        let result = [];
//        A.sort((a, b) => a - b);
//        let pf = [];
//        pf[0] = A[0];
//        for(let i=1; i<A.length; i++){
//            let prefixSum = pf[i-1] + A[i];
//            pf.push(prefixSum);
//        }
//
//        console.log('Array A: ', A);
//        console.log('PF of A : ', pf);
//
//        for(let i=0; i<B.length; i++){
//            let count = pf.length;
//            for(let j=pf.length-1; j>=0; j--){
//                if(pf[j] > B[i]){
//                    count--;
//                }else{
//                    break;
//                }
//            }
//            result.push(count);
//        }
//
//        console.log("Result : ", result);
    }

    private static void littlePonnyMaximumElement(){
        int[] A = {2, 4, 3, 1, 5};
        int B = 3;

        Integer[] arr = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        int count = 0;
        boolean isElementPreset = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == B){
                isElementPreset = true;
                break;
            }
            if(arr[i] > B){
                count++;
            }
        }

        int ans = isElementPreset ? count : -1;
    }

    private static void littlePonnyMaximumElementWithArraylist(){
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(4);
        A.add(3);
        A.add(1);
        A.add(5);
        Collections.sort(A, Collections.reverseOrder());

        System.out.println(A);
        int B = 3;

        int count = 0;
        boolean isElementPreset = false;
        for(int i=0; i<A.size(); i++){
            if(A.get(i) == B){
                isElementPreset = true;
                break;
            }
            if(A.get(i) > B){
                count++;
            }
        }

        int ans = isElementPreset ? count : -1;

        System.out.println("Ans: " + ans);
    }
}
