package com.mosh;

public class Contest1 {
    public static void main(String[] args) {
        int[] A = {-1, 2};
        int B = 10;

        int result = Bus(A, B);

        System.out.println(result);
    }

    public static int solve(int[] A, int B, int C) {
        int count = 0;
        for(int i=0; i<A.length; i++){
            for(int j=i; j<A.length; j++){
                if(checkPerfectDish(A, i, j, B, C)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean checkPerfectDish(int[] A, int i, int j, int B, int C){
        int sum = 0;
        boolean atleastOneIsPrime = false;
        for(int k=i; k<=j; k++){
            System.out.print(A[k] + " ");
            sum = sum + A[k];
            if(isPrime(A[k])){
                atleastOneIsPrime = true;
            }
        }
        System.out.println();
        if(atleastOneIsPrime && sum > B && sum <= C){
            return true;
        }

        return false;
    }

    private static boolean isPrime(int N){
        int c = 0;

        for(int i=1; i*i <= N; i++){
            if(N % i == 0){
                if( i == N/i){
                    c = c + 1;
                }else {
                    c = c + 2;
                }
            }
        }

        if(c == 2){
            return true;
        }

        return false;
    }

    public static int Bus(int[] A, int B) {

        int[] pf = new int[A.length];

        pf[0] = A[0];
        for(int i=1; i<A.length; i++){
            pf[i] = pf[i-1] + A[i];
        }

        int positivePeople = 0;
        int negativePeople = 0;

        for(int i=0; i<A.length; i++){
            if(A[i] > 0){
                for(int j=i+1; j<A.length; j++){
                    if(A[j] < 0){
                        positivePeople = pf[j-1];
                        break;
                    }else{
                        positivePeople = pf[j];
                    }
                }
                break;
            }else{
                for(int j=i+1; j<A.length; j++){
                    if(A[j] > 0){
                        negativePeople = pf[j-1];
                        break;
                    }else{
                        negativePeople = pf[j];
                    }
                }
                break;
            }
        }

        if(positivePeople != 0){
            return (B + 1) - positivePeople;
        }

        if(negativePeople != 0){
            return (B + 1) + negativePeople;
        }

        return 0;
    }
}
