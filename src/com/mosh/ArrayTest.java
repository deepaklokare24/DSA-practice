package com.mosh;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        byte T = scanner.nextByte();
        String[] evenResults = new String[T];
        String[] oddResults = new String[T];
        int index = 0;
        while(T > 0){
            int size = scanner.nextInt();
            int[] arr = new int[size];

            for(int i=0; i<size; i++){
                arr[i] = scanner.nextInt();
            }

            StringBuilder evenElements = new StringBuilder("");
            StringBuilder oddElements = new StringBuilder("");

            for(int i=0; i<size; i++){
                if(arr[i] % 2 == 0){
                    evenElements.append(arr[i] + " ");
                }else{
                    oddElements.append(arr[i] + " ");
                }
            }

            evenResults[index] = evenElements.toString().trim();
            oddResults[index] = oddElements.toString().trim();
            T--;
            index++;
        }

        for(int i=0; i<index; i++){
            System.out.println(oddResults[i]);
            System.out.println(evenResults[i]);
        }
    }
}
