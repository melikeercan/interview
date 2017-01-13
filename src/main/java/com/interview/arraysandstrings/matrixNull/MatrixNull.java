package com.interview.arraysandstrings.matrixNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MatrixNull {

    public static void main(String[] args) {
        int m = 5;
        int n = 4;
        int[][] matrixInitial = initMatrix(m, n);
        int[][] matrixFinal = matrixNull(matrixInitial, m, n);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrixFinal[i]));
        }
        System.out.println("****NEW*****");
        int[][] matrixFinalNew = matrixNullNew(matrixInitial, m, n);
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrixFinalNew[i]));
        }
    }

    /**
     * @param matrixInitial
     * @param m
     * @param n
     * @return
     */
    private static int[][] matrixNullNew(int[][] matrixInitial, int m, int n) {
        List<Integer> zeroRowList = new ArrayList<>(); // Store rows with 0
        List<Integer> zeroColumnList = new ArrayList<>(); // Store columns with 0
        for (int i = 0; i < m; i++) { // read through the matrix when you hit 0 add the column to zeroColumnList and add
                                      // the row to zeroRowList
            for (int j = 0; j < n; j++) {
                if (matrixInitial[i][j] == 0) {
                    if (!zeroRowList.contains(i)) {
                        zeroRowList.add(i);
                    }
                    if (!zeroColumnList.contains(j)) {
                        zeroColumnList.add(j);
                    }
                }
            }
        }

        for (int a = 0; a < m; a++) {
            if (zeroRowList.contains(a)) { // if the row has 0
                for (int b = 0; b < n; b++) {
                    matrixInitial[a][b] = 0; // replace all row with zero
                }
            }
        }

        for (int b = 0; b < n; b++) {
            if (zeroColumnList.contains(b)) { // if the column has 0
                for (int a = 0; a < m; a++) {
                    matrixInitial[a][b] = 0; // replace all column with zero
                }
            }
        }
        return matrixInitial;
    }

    public static int[][] matrixNull(int[][] matrixInitial, int m, int n) {
        int[][] matrixFinal = initFinal(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixInitial[i][j] == 0) {
                    makeZeroX(matrixFinal, i, j, m, n);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixFinal[i][j] == -1) {
                    matrixFinal[i][j] = matrixInitial[i][j];
                }
            }
        }
        return matrixFinal;
    }

    private static void makeZeroX(int[][] matrixFinal, int x, int y, int m, int n) {
        for (int j = 0; j < n; j++) {
            matrixFinal[x][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            matrixFinal[i][y] = 0;
        }
    }

    private static int[][] initMatrix(int m, int n) {

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Random rn = new Random();
                int random = rn.nextInt(10);
                matrix[i][j] = random;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("******");
        return matrix;
    }

    private static int[][] initFinal(int m, int n) {

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        return matrix;
    }

}
