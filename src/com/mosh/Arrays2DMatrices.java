package com.mosh;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Arrays2DMatrices {
    public static void main(String[] args) {
        printDiagonals();
    }

    private static void printNXMmatrixRowWise(){
        int[][] mat = {{3, 8, 9, 2}, {1, 2, 3, 6}, {4, 10, 11, 17}};
        int N = mat.length;
        int M = mat[0].length;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findMaxColumnWiseSum(){
        int[][] mat = {{3, 8, 9, 2}, {1, 2, 3, 6}, {4, 10, 11, 17}};
        int N = mat.length;
        int M = mat[0].length;

        int maxSum = Integer.MIN_VALUE;
        for(int j=0; j<M; j++){
            int sum = 0;
            for(int i=0; i<N; i++){
                sum += mat[i][j];
            }
            maxSum = Math.max(sum, maxSum);
        }

        System.out.println("Max Sum : " + maxSum);
    }

    private static void printDiagonals(){
        int[][] mat = { {-11, -2, -3},{-4, 5, -6},{-7, -8, -9} };
        int N = mat.length;
        int M = mat[0].length;

        System.out.println("<< Print Top left to Bottom Right >>");
        int i=0;
        int sum = 0;
        while(i<N){
            System.out.print(mat[i][i]+ " ");
            sum += mat[i][i];
            i++;
        }
        System.out.println("Main Diagonal sum : " + sum);
        System.out.println("\n<< Print Top right to Bottom left >>");
        int j=M-1;
        i = 0;
        while(i<N && j>=0){
            System.out.print(mat[i][j] + " ");
            i++;
            j--;
        }
    }

    private static void printAllDiagonalsFromRtoL(){
        int[][] mat = { {3, 8, 9, 2, 1, 4},
                        {1, 2, 3, 6, 3, 2},
                        {4, 0, 1, 7, 1, 0},
                        {7, 9, 2, 1, 0, 3}};
        int N = mat.length;
        int M = mat[0].length;

        for(int j=0; j<M; j++){
            int x=0, y=j;
            while(x<N && y>=0){
                System.out.print(mat[x][y] + " ");
                x++;
                y--;
            }
            System.out.println();
        }

        for(int i=1; i<N; i++){
            int x=i, y=M-1;
            while(x<N && y>=0){
                System.out.print(mat[x][y] + " ");
                x++;
                y--;
            }
            System.out.println();
        }
    }

    private static void antiDiagonalsMatrix(){
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int N = A.length;
        int[][] result = new int[(2*N)-1][N];

        int row=0, col=0;
        for(int j=0; j<N; j++){
            int x=0, y=j;
            col = 0;
            while(x<N && y>=0){
                result[row][col] = A[x][y];
                x++;
                y--;
                col++;
            }
            while(col < N){
                result[row][col] = 0;
                col++;
            }
            row++;
        }

        for(int i=1; i<N; i++){
            int x=i, y=N-1;
            col = 0;
            while(x<N && y>=0){
                result[row][col] = A[x][y];
                x++;
                y--;
                col++;
            }
            while(col < N){
                result[row][col] = 0;
                col++;
            }
            row++;
        }
        System.out.println(Arrays.deepToString(result));
    }

    private static void transposeOfaSquareMatrix(){
        int[][] mat = { {3, 8, 9, 2},
                        {1, 2, 3, 6},
                        {4, 0, 1, 7},
                        {7, 9, 2, 1} };
        int N = mat.length;

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        System.out.println(" << Transposed Matrix >> ");

        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private static void transposeOfAnyMatrix(){
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int N = A.length;
        int M = A[0].length;

        int[][] result = new int[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                result[i][j] = A[j][i];
            }
        }

        System.out.println(" << Transposed Matrix >> ");

        for(int i=0; i<M; i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static void rotateMatrix90degreeClockwise(){
        int[][] mat = { {3, 8, 9, 2},
                        {1, 2, 3, 6},
                        {4, 0, 1, 7},
                        {7, 9, 2, 1} };
        int N = mat.length;

        for(int i=1; i<N; i++){
            for(int j=0; j<i; j++){
                swapElements(mat, i, j);
            }
        }

        System.out.println(" << Transposed Matrix >> ");

        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(mat[i]));
        }

        System.out.println(" << Rotating MAtrix by 90 deg >> ");

        for(int i=0; i<N; i++){
            reverseAnArray(mat[i]);
        }

        for(int i=0; i<N; i++){
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    private static void swapElements(int[][] mat, int i, int j){
        mat[i][j] = mat[i][j] + mat[j][i];
        mat[j][i] = mat[i][j] - mat[j][i];
        mat[i][j] = mat[i][j] - mat[j][i];
    }

    private static void reverseAnArray(int[] arr){
        int N = arr.length;

        for(int i=0, j=N-1; i<N/2; i++, j--){
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }

    private static void printBoundariesOfSquareMatrixClockWise(){
        int[][] mat = { {1, 2, 3, 4, 5},
                        {6, 7, 8, 9, 10},
                        {11, 12, 13, 14, 15},
                        {16, 17, 18, 19, 20},
                        {21, 22, 23, 24, 25} };
        int N = mat.length;

        int i=0, j=0;

        for(int k=1; k<N; k++){
            System.out.print(mat[i][j] + " ");
            j++;
        }
        System.out.println();
        // i=0, j=N-1

        for(int k=1; k<N; k++){
            System.out.print(mat[i][j] + " ");
            i++;
        }
        System.out.println();
        // i=N-1, j=N-1

        for(int k=1; k<N; k++){
            System.out.print(mat[i][j] + " ");
            j--;
        }
        System.out.println();
        // i=N-1, j=0

        for(int k=1; k<N; k++){
            System.out.print(mat[i][j] + " ");
            i--;
        }
        System.out.println();
        // i=0, j=0
    }

    private static void spiralPrintingOfSquareMatrix(){
        int[][] mat = { {1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29, 30},
                        {31, 32, 33, 34, 35, 36}};
        int N = mat.length;

        int i=0, j=0;

        while (N > 1){
            for(int k=1; k<N; k++){
                System.out.print(mat[i][j] + " ");
                j++;
            }
            System.out.println();
            // i=0, j=N-1

            for(int k=1; k<N; k++){
                System.out.print(mat[i][j] + " ");
                i++;
            }
            System.out.println();
            // i=N-1, j=N-1

            for(int k=1; k<N; k++){
                System.out.print(mat[i][j] + " ");
                j--;
            }
            System.out.println();
            // i=N-1, j=0

            for(int k=1; k<N; k++){
                System.out.print(mat[i][j] + " ");
                i--;
            }
            System.out.println();
            // i=0, j=0

            i++;
            j++;
            N=N-2;
        }

        if(mat.length % 2 == 1){
            System.out.print(mat[i][j]);
        }
    }

    private static void spiralFillSquareMatrix(){
        int A = 1;
        int[][] result = new int[A][A];
        int N = A;

        int i=0, j=0, filler=1;

        while (N > 1){
            for(int k=1; k<N; k++){
                result[i][j] = filler;
                j++;
                filler++;
            }
            // i=0, j=N-1

            for(int k=1; k<N; k++){
                result[i][j] = filler;
                i++;
                filler++;
            }
            // i=N-1, j=N-1

            for(int k=1; k<N; k++){
                result[i][j] = filler;
                j--;
                filler++;
            }
            // i=N-1, j=0

            for(int k=1; k<N; k++){
                result[i][j] = filler;
                i--;
                filler++;
            }
            // i=0, j=0

            i++;
            j++;
            N=N-2;
        }

        if(A % 2 == 1){
            result[i][j] = filler;
        }
        System.out.println(Arrays.deepToString(result));
    }

    private static void matrixAddition(){
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        int N = A.length;
        int M = A[0].length;
        int[][] result = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        System.out.println(Arrays.deepToString(result));
    }

    private static void matrixMultiplication(){
        int[][] A = {{1, 1}, {2, 2}, {3, 3}};
        int[][] B = {{1, 1, 1}, {2, 2, 2}};
        int[][] result = new int[A.length][B[0].length];

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B[0].length; j++){
                result[i][j] = 0;

                for(int k=0; k<B.length; k++){
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println(Arrays.deepToString(result));
    }

    private static void makeRowtoColumnZero(){
        int[][] A ={{51, 21, 90, 38, 57, 12, 11, 1,  68, 60},
                    {81, 24, 63, 97, 75, 70, 23, 91, 39, 84},
                    {0,  21, 97, 12, 46, 48, 50, 3,  57, 69},
                    {44, 8,  42, 34, 99, 0,  98, 10, 53, 67},
                    {23, 34, 43, 86, 31, 18, 9,  54, 61, 48},
                    {90, 61, 21, 87, 26, 67, 88, 28, 70, 45},
                    {98, 14, 5,  92, 1,  4,  44, 99, 67, 98},
                    {18, 42, 32, 61, 80, 64, 32, 89, 70, 93},
                    {89, 61, 7,  10, 0,  85, 29, 40, 13, 0},
                    {85, 63, 66, 43, 56, 67, 99, 0,  67, 66}};

        int N = A.length;
        int M = A[0].length;
        int[][] result = new int[N][M];
        String[] keyValues = new String[A.length * A[0].length];

        int len = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                result[i][j] = A[i][j];
                if(A[i][j] == 0){
                    System.out.println(i + " - " + j);
                    keyValues[len] = i+""+j;
                    len++;
                }
            }
        }

        System.out.println("Iterating over hashmap");
        for(int k=0; k<len; k++){
            String[] indices = keyValues[k].split("");
            System.out.println(indices[0] + ">" + indices[1]);
            changeToZeros(result, Integer.parseInt(indices[0]), Integer.parseInt(indices[1]));
        }

        System.out.println(Arrays.deepToString(result));
    }

    private static void changeToZeros(int[][] A, int rowIndex, int colIndex) {
        int j = 0;
        while(j < A[0].length){
            A[rowIndex][j] = 0;
            j++;
        }
        int i = 0;
        while(i < A.length){
            A[i][colIndex] = 0;
            i++;
        }
    }
}
