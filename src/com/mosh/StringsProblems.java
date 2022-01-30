package com.mosh;

public class StringsProblems {
    public static void main(String[] args) {
        substringOfZerosAndOnes();
    }

    private static void substringOfZerosAndOnes(){
        String A = "00011011";

        int zerosCount = 0;
        int onesCount = 0;
        int count = 0;

        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '0'){
                zerosCount++;
            }else {
                onesCount++;
            }

            if(zerosCount == onesCount){
                count++;
            }
        }

        int ans = count;

        if(zerosCount != onesCount){
            ans = -1;
        }

        int result = 5;
        System.out.println(Integer.toString(result));
        System.out.println(ans);

        System.out.println(Integer.toBinaryString(90));
    }
}
