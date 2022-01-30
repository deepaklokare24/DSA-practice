package com.mosh;

import java.util.*;

public class Hashing2 {
    public static void main(String[] args) {
        validateSodoku();
    }

    private static void checkIfPairExistsBruteForceWithOptimisation(){
        int[] A = {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0};
        int k = 53;

        for(int i=0, j=A.length-1; i<A.length/2; i++, j--){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        System.out.println(Arrays.toString(A));

        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i] - A[j] == k || A[i] - A[j] == -k){
                    System.out.println("THe pair exists! " + A[i] + " , " + A[j]);
                    return;
                }
            }
        }

        System.out.println("There is no such pair");
    }

    private static void checkIfPairExistsUsingSet(){
        int[] A = {2, 9, 11, 9, 15, 12, 17};
        int k = 18;
        Set<Integer> checkSet = new HashSet<>();

        boolean pairExists = false;

        for(int i=0; i<A.length; i++){
            if(checkSet.contains(k - A[i])){
                pairExists = true;
            }else{
                checkSet.add(A[i]);
            }
        }

        System.out.println("Does such pair exists: " + pairExists);
    }

    private static void checkIfPairExistsUsingSet1(){
        // A[i] - A[j] = B
//        diffPossible : function(A, B){
//
//            let checkSet = new Set();
//
//            if(A.length < 2 || B < 0){
//                return 0;
//            }
//
//            for(let i=0; i<A.length; i++){
//                let Aj = A[i] - B;
//                let Ai = A[i] + B;
//
//                if(checkSet.has(Aj)){
//                    return 1;
//                }
//                if(checkSet.has(Ai)){
//                    return 1;
//                }
//                checkSet.add(A[i]);
//            }
//            return 0;
//        }
    }

    private static void countTheNumberOfPairExistsUsingSet(){
        int[] A = {2, 9, 14, 9, 15, 4, 17};
        int k = 18;
        Set<Integer> checkSet = new HashSet<>();

        int pairCount = 0;

        for(int i=0; i<A.length; i++){
            if(checkSet.contains(k - A[i])){
                pairCount++;
            }else{
                checkSet.add(A[i]);
            }
        }

        System.out.println("count of such pair: " + pairCount);
    }

    private static void countTheNumberOfDistinctElementsInEveryWindowK_bruteForce(){
        int[] A = {6, 3, 7, 3, 8, 6, 9};
        int N = A.length;
        int k = 3;
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int s=0, e=k-1; s<=N-k; s++, e++){
            for(int i=s; i<=e; i++){
                set.add(A[i]);
            }
            result.add(set.size());
            set.clear();
        }

        System.out.println(result);
    }

    private static void countTheNumberOfDistinctElementsInEveryWindowK_slidingWindow(){
        int[] A = {5, 3, 2, 5, 1, 5, 2};
        int N = A.length;
        int k = 3;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<k; i++){
            if(freqMap.containsKey(A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            }else{
                freqMap.put(A[i], 1);
            }
        }
        result.add(freqMap.size());

        for(int s=1, e=k; s<=N-k; s++, e++){
            // remove (s-1)th element from freqMap
            if(freqMap.get(A[s-1]) > 1){
                freqMap.put(A[s-1], freqMap.get(A[s-1])-1);
            }else {
                freqMap.remove(A[s-1]);
            }

            // add (e)th element in freqMap
            if(freqMap.containsKey(A[e])){
                freqMap.put(A[e], freqMap.get(A[e])+1);
            }else{
                freqMap.put(A[e], 1);
            }

            result.add(freqMap.size());
        }

        System.out.println(result);
    }

    private static void findLargestSubsequenceOfConsecutiveNumbersUsingSort(){
        int[] A = {100, 101, 99, 98, 7, 6, 87, 102};
        Arrays.sort(A);
        System.out.println(Arrays.toString(A));

        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<A.length-1; i++){
            int length = 1;
            for(int j=i+1, k=1; j<A.length; j++, k++){
                if(A[i]+k == A[j]){
                    length++;
                }else{
                    break;
                }
            }
            maxLength = Math.max(length, maxLength);
        }

        System.out.println("Max length of consecutive Sub Sequence : " + maxLength);
    }

    private static void findLargestSubsequenceOfConsecutiveNumbersUsingHashSet(){
        int[] A = {6, 6, 6, 6, 6, 6, 7, 8, 9, 10};
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<A.length; i++){
            set.add(A[i]);
        }

        int maxLength = Integer.MIN_VALUE;
//        for(int i=0; i<A.length; i++){
//            if(!set.contains(A[i]-1)){
//                int length = 1;
//                int x = A[i] + 1;
//                while(set.contains(x)){
//                    length++;
//                    x++;
//                }
//                maxLength = Math.max(length, maxLength);
//            }
//        }

        // to avoid duplicates in array we can just iterate over set and find the length
        for(Integer element : set){
            if(!set.contains(element-1)){
                int length = 1;
                int x = element + 1;
                while(set.contains(x)){
                    length++;
                    x++;
                }
                maxLength = Math.max(length, maxLength);
            }
        }

        System.out.println("Max length of consecutive Sub Sequence : " + maxLength);
    }

    private static void subArrayWithGivenSumBruteForce(){
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<A.length; i++){
            int sum = A[i];
            result.add(A[i]);
            for(int j=i+1; j<A.length; j++){
                sum = sum + A[j];
                if(sum < B){
                    result.add(A[j]);
                }
                if(sum == B){
                    result.add(A[j]);
                    System.out.println(result);
                    return;
                }
                //System.out.println(A[j] + " " + "Sum : " + sum);
            }
           result.clear();
        }
    }

    private static void subArrayWithGivenSumHashSet1() {
        int[] A = {5, 10, 20, 100, 105};
        int K = 110;
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        freqMap.put(0, -1);
        int sumSoFar = 0;
        for(int i=0; i<A.length; i++){
            sumSoFar += A[i];

            if(freqMap.containsKey(sumSoFar - K)){
                int index = freqMap.get(sumSoFar - K);
                for(int k=index+1; k<=i; k++){
                    result.add(A[k]);
                }
                System.out.println(result);
                return;
            }
            freqMap.put(sumSoFar, i);
        }
        System.out.println(-1);
    }

    private static void subArrayWithGivenSumSlidingWindow(){
        int[] A = {15, 3, 6, 9, 2, 5};
        int B = 7;
        List<Integer> result = new ArrayList<>();

        int i=0;
        int j=0;
        int sum = A[i];

        while(j<A.length){
            if(sum < B){
                j++;
                if(j<A.length){
                    sum += A[j];
                }
            }
            if(sum > B){
                sum -= A[i];
                i++;
            }
            if(sum == B){
                for(int k=i; k<=j; k++){
                    result.add(A[k]);
                }
                System.out.println(result);
                break;
            }
        }

        System.out.println(-1);
    }

    private static void checkPairsWithGivenXOR(){
        int[] A = {3, 6, 8, 10, 15, 50};
        int B = 5;

        Set<Integer> checkSet = new HashSet<>();
        int pairCount = 0;

        for(int i=0; i<A.length; i++){
            if(checkSet.contains(B ^ A[i])){
                pairCount++;
            }else{
                checkSet.add(A[i]);
            }
        }

        System.out.println("No of paris: " + pairCount);
    }

    private static void validateSodoku(){
        String[] A = {"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"};
        int[][] sodokuMatrix = new int[9][9];
        Set<Integer> checkSet = new HashSet<>();
        boolean isValid = true;
        for(int i=0; i<A.length; i++){
            String row = A[i];
            for(int j=0; j<row.length(); j++){
                if(row.charAt(j) != '.'){
                    int cellValue = Integer.parseInt(String.valueOf(row.charAt(j)));
                    sodokuMatrix[i][j] = cellValue;
                    if(checkSet.contains(cellValue)){
                        isValid = false;
                        break;
                    }else{
                        checkSet.add(cellValue);
                    }
                }else{
                    sodokuMatrix[i][j] = 0;
                }
            }
            checkSet.clear();
        }
        System.out.println("Is it a valid with Row comparison? " + isValid);

        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                if(sodokuMatrix[i][j] != 0){
                    if(checkSet.contains(sodokuMatrix[i][j])){
                        isValid = false;
                        break;
                    }else{
                        checkSet.add(sodokuMatrix[i][j]);
                    }
                }
            }
            checkSet.clear();
        }

        System.out.println("Is it a valid with column comparison? " + isValid);

        for (int x = 0; x < 9; x+=3) {
            for (int y = 0; y < 9; y+=3) {
                for (int bx = x; bx < x + 3; bx++) {
                    for (int by = y; by < y + 3; by++) {
                        if(sodokuMatrix[bx][by] != 0){
                            if(checkSet.contains(sodokuMatrix[bx][by])){
                                isValid = false;
                                break;
                            }else{
                                checkSet.add(sodokuMatrix[bx][by]);
                            }
                        }
                    }
                }
                checkSet.clear();
            }
        }

        System.out.println("Is it a valid with each box comparsion? " + isValid);
    }

    private static void sortingStringsAsPerAlianAlphabets(){
//        let A = ["hello", "scaler", "interviewbit"];
//        let B = "adhbcfegskjlponmirqtxwuvzy";
//
//        let copyA = [...A];
//        let alphaMap = new Map();
//
//        for (let i = 1; i <= B.length; i++) {
//            alphaMap.set(B[i - 1], i);
//        }
//
//        A.sort((a, b) => {
//            let i = 0;
//            let aValue = alphaMap.get(a[i]);
//            let bValue = alphaMap.get(b[i]);
//            if (aValue < bValue) {
//                return -1;
//            }
//            if (aValue > bValue) {
//                return 1;
//            }
//
//            let aLength = a.length;
//            let bLength = b.length;
//            let N = aLength > bLength ? bLength : aLength;
//
//            while (aValue === bValue && i < N) {
//                i++;
//                aValue = alphaMap.get(a[i]);
//                bValue = alphaMap.get(b[i]);
//                if (!aValue) {
//                    return -1;
//                }
//                if (!bValue) {
//                    return 1;
//                }
//                if (aValue < bValue) {
//                    return -1;
//                }
//                if (aValue > bValue) {
//                    return 1;
//                }
//            }
//        });
//
//        let isEqual = true;
//        for (let i = 0; i < A.length; i++) {
//            if (A[i] !== copyA[i]) {
//                isEqual = false;
//                break;
//            }
//        }
//
//        console.log("is Equal : " + isEqual);

    }
}
