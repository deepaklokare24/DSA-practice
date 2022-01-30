package com.mosh;

import java.util.*;

public class Strings {
    public static void main(String[] args) {
        changeCharacterUsingMapDintWork();
    }

    private static void toggleCaseOfString(){
        StringBuilder str = new StringBuilder("aAbBcC");

        System.out.println("Before : " + str);
        for(int i=0; i<str.length(); i++){
            char atI = str.charAt(i);
            if(atI >= 'A' && atI <= 'Z'){
                str.setCharAt(i, (char) (atI+32));
            }else if(atI >= 'a' && atI <= 'z'){
                str.setCharAt(i, (char) (atI-32));
            }
        }
        System.out.println("After : " + str);

    }

//    function toggleCaseOfString(str) {
//        let charArray = [...str];
//        for (let i = 0; i < charArray.length; i++) {
//            let asciiCode = charArray[i].charCodeAt(0);
//
//            if (asciiCode >= 65 && asciiCode <= 90) {
//                charArray[i] = String.fromCharCode(asciiCode + 32);
//            } else if (asciiCode >= 97 && asciiCode <= 122) {
//                charArray[i] = String.fromCharCode(asciiCode - 32);
//            }
//        }
//        str = charArray.join("");
//        console.log(str);
//        return str;
//    }


    private static void toggleCaseOfStringUsingXor(){
        StringBuilder str = new StringBuilder("aAbBcC");

        System.out.println("Before : " + str);
        for(int i=0; i<str.length(); i++){
            str.setCharAt(i, (char) (str.charAt(i)^32));
        }
        System.out.println("After : " + str);
    }

    private static void sortStringWithLowerCaseCharacters(){
        StringBuilder str = new StringBuilder("dabaedb");
        StringBuilder result = new StringBuilder();

        int[] freqArray = new int[26];

        System.out.println(Arrays.toString(freqArray));

        System.out.println(str);

        for(int i=0; i<str.length(); i++){
            int index = str.charAt(i) - 'a';
            freqArray[index]++;
        }
        System.out.println(Arrays.toString(freqArray));

        for(int i=0; i<freqArray.length; i++){
            if(freqArray[i] != 0){
                for(int j=0; j<freqArray[i]; j++){
                    result.append((char)('a'+i));
                }
            }
        }
        System.out.println("outuppt: " + result);
    }

    private static void reverse(StringBuilder str, int s, int e){
        while(s < e){
            char temp = str.charAt(s);
            str.setCharAt(s, str.charAt(e));
            str.setCharAt(e, temp);
            s++;
            e--;
        }
    }

    private static void reverseASentence(){
        StringBuilder str = new StringBuilder("crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ");
        reverse(str, 0, str.length()-1);
        System.out.println(str);
        int s = 0, e = 0;

        for(int i=0; i<str.length(); i++){
            if(i == str.length()-1){
                reverse(str, s, i);
            }
            if(str.charAt(i) == ' '){
                e = i-1;
                reverse(str, s, e);
                s = i+1;
            }
        }
        System.out.println(str.toString().trim());
    }

    private static void calculateLengthOfLargestPalindromicSubstring(){
        StringBuilder str = new StringBuilder("xbdyzzydbdyzydx");
        int maxLength = 0;

        for(int i=1; i<str.length()-1; i++){
            // check length of odd palindrome
            int length = getLengthOfPalindrome(str, i, i);
            maxLength = Math.max(length, maxLength);

            // check length of even palindrome
            length = getLengthOfPalindrome(str, i, i+1);
            maxLength = Math.max(length, maxLength);
        }
        System.out.println("max length of palindrome : " + maxLength);
    }

    private static void printLargestPalindromicSubstring(){
        StringBuilder str = new StringBuilder("abb");
        int N = str.length();
        int maxLength = 0;
        int s = 0, e = 0;
        for(int k=0; k<N; k++){
            // check length of odd palindrome
            int length = 0;
            int i = k, j = k;

            while(( i>=0 && j<N ) && str.charAt(i) == str.charAt(j)){
                i--;
                j++;
            }
            length = j-i-1;

            if(maxLength < length){
                maxLength = length;
                s = i+1;
                e = j-1;
            }

            // check length of even palindrome
            i = k;
            j = k+1;

            while(( i>=0 && j<N ) && str.charAt(i) == str.charAt(j)){
                i--;
                j++;
            }
            length = j-i-1;
            if(maxLength < length){
                maxLength = length;
                s = i+1;
                e = j-1;
            }
        }
        System.out.println(str.substring(s, e+1));
        System.out.println("max length of palindrome : " + maxLength + " with index : " + s + " , " + e);
    }

    private static int getLengthOfPalindrome(StringBuilder str, int ci, int cj){
        int i = ci;
        int j = cj;
        int N = str.length();

        while(( i>=0 && j<N ) && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    private static void countTheNumberOfAmazingSubArrays(){
        String A = "ABEC";
        int count = 0;
        int N = A.length();

        for(int i=0; i<A.length(); i++){
            if(isVowel(A.charAt(i))){
                count = count + (N - i);
            }
        }

        System.out.println("Count of Amazing subarrays : " + count);
    }

    private static boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return  true;
        }
        return false;
    }

    private static void countTheNumberOfBobInString(){
        StringBuilder str = new StringBuilder("rbobobbobljzjdbobbobpncbobobobadbobvlrrbobmypibobbqiycbobdcpbobybobgjqgbobuccboboybobmbob");
        int N = str.length();
        int bobCount = 0;

        for(int k=0; k<N; k++){
            // check length of odd palindromes
            int length = 0;
            if(str.charAt(k) == 'o'){
                int i = k, j = k;

                while(( i>=0 && j<N ) && str.charAt(i) == str.charAt(j) && length < 3){
                    i--;
                    j++;
                    length = j-i-1;
                }

                if(length == 3 && str.substring(i+1, j).equals("bob")){
                    bobCount++;
                }
            }

        }
        System.out.println("bob count : " + bobCount);
    }

    private static void changeCharacterUsingMapDintWork(){
        String A = "qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";
        int B = 119;

        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i=0; i<A.length(); i++){
            char chi = A.charAt(i);
            if(freqMap.containsKey(chi)){
                freqMap.put(chi, freqMap.get(chi)+1);
            }else{
                freqMap.put(chi, 1);
            }
        }

        System.out.println(freqMap);
        for(int i=1; i<=B; i++){
            Iterator it = freqMap.entrySet().iterator();

            while(it.hasNext()){
                if(B <= 0){
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if((int)entry.getValue() <= i && i<=B){
                    it.remove();
                    B = B - (int)entry.getValue();
                }
            }
        }

//        System.out.println(B + "  " + freqMap);
//        it = freqMap.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry entry = (Map.Entry) it.next();
//            if((int)entry.getValue() == B){
//                B = B - (int)entry.getValue();
//                it.remove();
//            }
//        }
        System.out.println(B + "  " + freqMap);
        System.out.println("No of distinct chars :" + freqMap.size());
    }

    private static void changeCharacterUsingFreqArray(){
        String A = "qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";
        int B = 119;

        int[] freqArray = new int[26];

        for(int i=0; i<A.length(); i++){
            int index = A.charAt(i) - 'a';
            freqArray[index]++;
        }

        System.out.println(Arrays.toString(freqArray));
    }

    private static void stringOperations(){
//        let A = "AbcaZeoB";
//        let charArray = [...A];
//        for (let i = 0; i < A.length; i++) {
//            if (!(A[i] >= "A" && A[i] <= "Z")) {
//                charArray.push(charArray[i]);
//            }
//        }
//
//        for (let i = charArray.length - 1; i >= 0; i--) {
//            if (charArray[i] >= "A" && charArray[i] <= "Z") {
//                charArray.splice(i, 1);
//            }
//            if (isVowel(charArray[i])) {
//                charArray[i] = "#";
//            }
//        }
//
//        function isVowel(ch) {
//            if (ch === "a" || ch === "e" || ch === "i" || ch === "o" || ch === "u") {
//                return true;
//            }
//            return false;
//        }
//        console.log(charArray.join(""));
    }
}
