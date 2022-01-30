package com.mosh;

import java.util.ArrayList;

public class SubsequenceAndSubsets {
    public static void main(String[] args) {
        countTheOccurancesOfAG();
    }

    private static void printAllTheSubsequences(){
        int[] A = {-2, 6, 4};
        int N = A.length;
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();

        for(int i=0; i<(1<<N); i++) {
            ArrayList<Integer> eachSubset = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    eachSubset.add(A[j]);
                }
            }
            allSubsets.add(eachSubset);
        }

        System.out.println(allSubsets);
    }

    private static void checkIfSubsetExitsWithSumEqualsK(){
        int[] A = {3, -1, 0, 6, 2, -3, 5};
        int N = A.length;
        int K = 10;
        boolean doesExists = false;

        for(int i=0; i<(1<<N); i++){
            int sum = 0;
            for(int j=0; j<N; j++){
                if((i & (1 << j)) != 0){
                    sum += A[j];
                }
            }
            if(sum == K){
                doesExists = true;
                break;
            }
        }

        System.out.println("Does exists :" + doesExists);
    }

    private static void countTheOccurancesOfAG(){
        String A = "GGADSEGGAAIAPGAAUAAADAGAACDXN";
        int N = A.length();
        int counter = 0;

        for(int i=0; i<(1<<N); i++){
            StringBuffer sb = new StringBuffer();

            for(int j=0; j<N; j++){
                if((i & (1 << j)) != 0){
                    if(sb.length() > 2){
                        break;
                    }
                    sb.append(A.charAt(j));
                }
            }

            if(sb.toString().equals("AG")){
                counter++;
            }
        }

        System.out.println("The no of times AG occurs :" + counter);
    }
}
