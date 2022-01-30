package com.mosh;

import java.util.*;

public class Hashing1 {
    public static void main(String[] args) {
        HashMapBasics();
    }

    private static void HashMapBasics() {
        Map<String, Boolean> holtelRooms = new HashMap<>();

        holtelRooms.put("kaveri", true);
        holtelRooms.put("godavari", false);
        holtelRooms.put("narmada", true);

        // Option 1
        Set<String> keys =  holtelRooms.keySet();

        System.out.println("Iterating over HashMap using Keyset >>");
        for(String name: keys){
            System.out.println("Name: " + name + " Status : " + holtelRooms.get(name));
        }

        // Option 2
        System.out.println("Iterating over HashMap using Map.Entry and entrySet >>");
        for(Map.Entry<String, Boolean> entry : holtelRooms.entrySet()){
            System.out.println("Name : " + entry.getKey() + " Status : " + entry.getValue());
        }

        // Option 3
        System.out.println("Iterating over HashMap using Iterator >>");
        Iterator it = holtelRooms.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("Name : " + entry.getKey() + " Status : " + entry.getValue());
        }
    }

    private static void findTheFrequencyOfElementBrute(){
        int [] A = {2, 6, 3, 8, 2, 8, 2, 3, 8};

        int[] queries = {3, 2, 8, 6};

        // Brute Force Approach
        for(int i=0; i<queries.length; i++){
            int count = 0;
            for(int j=0; j<A.length; j++){
                if(A[j] == queries[i]){
                    count++;
                }
            }
            System.out.println("Freq of " + queries[i] + " is = " + count);
        }
    }

    private static void findTheFrequencyOfElementUsingHashMap(){
        int [] A = {2, 6, 3, 8, 2, 8, 2, 3, 8};
        int[] queries = {3, 2, 8, 6};
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<A.length; i++){
            if(freqMap.containsKey(A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            }else{
                freqMap.put(A[i], 1);
            }
        }

        System.out.println(freqMap);
        for(int i=0; i<queries.length; i++){
            System.out.println("Freq of " + queries[i] + " is = " + freqMap.get(queries[i]));
        }
    }

    private static void countTheNumberOfDistinctElements(){
        int[] A = {7, 3, 2, 1, 3, 7, 0};
        Map<Integer, Integer> freqMap = new HashMap<>();
        // Approach #1 create a frequency map and then return the size of Map

        for(int i=0; i<A.length; i++){
            freqMap.put(A[i], 1);
        }
        System.out.println("HashMap entries : " + freqMap);
        System.out.println("The total Number of distinct Elements : " + freqMap.size());

        // Approach #2 create a Hashset and push all the elements from the array
        // oNly the unique elements will be pushed

        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int i=0; i<A.length; i++){
            uniqueNumbers.add(A[i]);
        }
        System.out.println("HashSet values : " + uniqueNumbers);
        System.out.println("The total Number of distinct Elements : " + uniqueNumbers.size());
    }

    private static void findTheFirstNonRepeatingElementInanArray(){
        int[] A = {8, 2, 8, 3, 1, 2, 6, 5};
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<A.length; i++){
            if(freqMap.containsKey(A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            }else{
                freqMap.put(A[i], 1);
            }
        }
        System.out.println(freqMap);

        for(int i=0; i<A.length; i++){
            if(freqMap.get(A[i]) == 1){
                System.out.println("The First Non repeating Element is : " + A[i]);
                break;
            }
        }
    }

    private static void findCommonElementsInTwoArray(){
        int[] A = {2, 1, 4, 10};
        int[] B = {3, 6, 2, 10, 10};

        Map<Integer, Integer> freqMapA = new HashMap<>();
        Set<Integer> setA = new HashSet<>();
        Map<Integer, Integer> freqMapB = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<A.length; i++){
            setA.add(A[i]);
            if(freqMapA.containsKey(A[i])){
                freqMapA.put(A[i], freqMapA.get(A[i])+1);
            }else{
                freqMapA.put(A[i], 1);
            }
        }

        for(int i=0; i<B.length; i++){
            if(freqMapB.containsKey(B[i])){
                freqMapB.put(B[i], freqMapB.get(B[i])+1);
            }else{
                freqMapB.put(B[i], 1);
            }
        }

        System.out.println(freqMapA);
        System.out.println(freqMapB);

        for(Integer key : setA){
            if(freqMapB.containsKey(key)){
                int diff = 0;
                int freqA = freqMapA.get(key);
                int freqB = freqMapB.get(key);

                if(freqA == freqB){
                    diff = freqA;
                }else if(freqA > freqB){
                    diff = freqB;
                }else{
                    diff = freqA;
                }
                for(int i=0; i<diff; i++){
                    result.add(key);
                }
            }
        }

        System.out.println("Final Result : " + result);

        int[] arr = result.stream().mapToInt(i -> i).toArray();

        System.out.println(Arrays.toString(arr));
    }

    private static void checkSubArraySumEqualsZeroBruteForce(){
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3};
        boolean flag = false;
        //Brute Force Approach

        for(int i=0; i<A.length; i++){
            for(int j=i; j<A.length; j++){
                int sum = 0;
                for(int k=i; k<=j; k++){
                    sum += A[k];
                }
                if(sum == 0){
                    flag = true;
                    break;
                }
            }
        }

        System.out.println("Is there any subarray with sum equals to zero: " + flag);
    }

    private static void checkSubArraySumEqualsZeroPrefixSum(){
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3};
        long[] pf = new long[A.length];
        boolean flag = false;
        //Prefix Sum Approach

        pf[0] = A[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
        }

        System.out.println("Prefix Array : " + Arrays.toString(pf));
        for(int i=0; i<A.length; i++){
            for(int j=i; j<A.length; j++){
                long sum = 0;
                if(i == 0){
                    sum = pf[j];
                }else{
                    sum = pf[j] - pf[i-1];
                }
                if(sum == 0){
                    flag = true;
                    break;
                }
            }
        }

        System.out.println("Is there any sub array with sum equals to zero: " + flag);
    }

    private static void checkSubArraySumEqualsZeroUsingHashMap(){
        int[] A = {2, 2, 1, -3, 4, 3, 1, -2, -3};
        int[] pf = new int[A.length];
        boolean flag = false;
        //Prefix Sum Approach

        pf[0] = A[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
        }

        System.out.println("Prefix Array : " + Arrays.toString(pf));

        // check if there exists any duplicates in a pf array

        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<pf.length; i++){
            if(freqMap.containsKey(pf[i])){
                flag = true;
                break;
            }else{
                freqMap.put(pf[i], 1);
            }
        }

        Set<Integer> checkSet = new HashSet<>();
        for(int i=0; i<pf.length; i++){
            if(checkSet.contains(pf[i])){
                flag = true;
                break;
            }else {
                checkSet.add(pf[i]);
            }
        }
        System.out.println("Is there any sub array with sum equals to zero: " + flag);
    }

    private static void largestContinuousSequenceWithZeroSum(){
//        let A = [10, 13, -1, 8, 29, 1, 24, 8, 21, 20, 21, -23, -21, 0];
//        let pf = [];
//        pf[0] = A[0];
//        for(let i=1; i<A.length; i++){
//            pf[i] = pf[i-1] + A[i];
//        }
//
//        console.log(pf);
//        let freqMap = new Map();
//        let commonElements = [];
//
//        let start = null;
//        let end = null;
//        let distance = -1;
//
//        if(pf[0] === 0){
//            start = 0;
//            end = 0;
//            distance = 1;
//        }
//        for(let i=0; i<pf.length; i++){
//            if(pf[i] === 0 && distance < i){
//                start = 0;
//                end = i;
//                distance = i;
//            }
//            if(freqMap.has(pf[i])){
//                freqMap.set(pf[i], freqMap.get(pf[i])+1);
//            }else{
//                freqMap.set(pf[i], 1);
//            }
//        }
//
//        for(const [key, value] of freqMap){
//            console.log(key, value);
//            if(value > 1){
//                commonElements.push(key);
//            }
//        }
//
//        console.log('common elements : ', commonElements);
//
//        let flag = false;
//
//        console.log('distance: ', distance);
//
//        for(let i=0; i<commonElements.length; i++){
//            if(distance < (pf.lastIndexOf(commonElements[i]) - pf.indexOf(commonElements[i]) -1)){
//                flag = true;
//                start = pf.indexOf(commonElements[i]);
//                end = pf.lastIndexOf(commonElements[i]);
//                distance = end - start - 1;
//            }
//        }
//
//        console.log('start: ', start, ' end : ', end, 'distance : ', distance, 'flag : ', flag);
//        if(flag){
//            console.log(A.slice(start+1, end+1));
//        }else{
//            console.log(A.slice(0, end+1));
//        }
    }

    private static void shaggyAndMinDistances(){
        int[] A = {7, 1, 3, 4, 2, 9};
        Map<Integer, Integer> indexMap = new HashMap<>();
        int distance = Integer.MAX_VALUE;
        for(int i=0; i<A.length; i++){
            if(indexMap.containsKey(A[i])){
                distance = Math.min(distance, (i - indexMap.get(A[i])) );
            }else{
                indexMap.put(A[i], i);
            }
        }

        System.out.println("Minimum distance: " + distance);
    }

    private static void GrootTreesHeightsSum(){
        int [] A = {0, 0, 1};
        int k = 2;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int i=0; i<A.length; i++){
            if(freqMap.containsKey(A[i])){
                freqMap.put(A[i], freqMap.get(A[i])+1);
            }else{
                freqMap.put(A[i], 1);
            }
        }

        int sum = 0;

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if(entry.getValue() == k){
                sum = (int) ((sum + entry.getKey()) % (Math.pow(10, 9) + 7));
            }
        }

        System.out.println(" Total Sum : " + sum);
    }

    private static void checkPalindrome(){
        String A = "mnxljrajwhxiaquajokwvoqqphylxpbanmmhfxsmssxzsdnprtgibuhaxnwxzfozexiascybplaaqjcthuydnoowmkzyamodzknkqmwdglqqnhflfslqyowcangsddhcjjuiyfbdkevlghbictrvnmnathotrekyrggwcmbzorqtyeowksywlbetsyhjvczcnvusfdrxythrhhoxtuuprqftgwohcgpngktkharijsovuknae";
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i=0; i<A.length(); i++){
            if(freqMap.containsKey(A.charAt(i))){
                freqMap.put(A.charAt(i), freqMap.get(A.charAt(i))+1);
            }else{
                freqMap.put(A.charAt(i), 1);
            }
        }

        int countOfOddFreq = 0;
        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if(entry.getValue() % 2 == 1){
                countOfOddFreq++;
            }
            if(countOfOddFreq  > 1){
                break;
            }
        }

        // if the count of odd number of frequencies is greater than 1 then its not a palindrome

        System.out.println(countOfOddFreq);
    }

    private static void colorfulNumber(){
        int number = 124;
        String A = String.valueOf(number);
        Set<Integer> checkSum = new HashSet<>();

        for(int i=0; i<A.length(); i++){
            for(int j=i; j<A.length(); j++){
//                if(i == 0 && j == A.length()-1){
//                    continue;
//                }

                int product = 1;
                for(int k=i; k<=j; k++){
                    product = product * Integer.parseInt(String.valueOf(A.charAt(k)));
                    System.out.print(A.charAt(k) + " ");
                }
                System.out.println(" product : " + product);
                System.out.println();

                if(checkSum.contains(product)){
                    break;
                }else{
                    checkSum.add(product);
                }

            }
            System.out.println();
        }

        System.out.println(checkSum);
    }
}
