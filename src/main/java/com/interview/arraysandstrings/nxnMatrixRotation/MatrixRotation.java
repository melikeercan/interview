/**
 *
 */
package com.interview.arraysandstrings.nxnMatrixRotation;

import java.util.Arrays;

/**
 * @author MelikeErcan
 *
 */
public class MatrixRotation {

	  /**
     * @param args
     */
    public static void main(String[] args) {
        int n = 5;
        int[][] matrixInitial = initMatrix(n);
        int[][] matrixFinal = rotate(matrixInitial, n);
        System.out.println(matrixFinal.length);
        
        int m = 4;
        int[][] matrixInitial2 = initMatrix(m);
        int[][] matrixFinal2 = rotate(matrixInitial2, m);
        System.out.println(matrixFinal2.length);
    }

    private static int[][] rotate(int[][] matrixInitial, int n) {

        int layerCount = (n + 1) / 2;
        int[][] matrixFinal = new int[n][n];
        if (n % 2 == 1) {
            matrixFinal[n / 2][n / 2] = matrixInitial[n / 2][n / 2];
            layerCount -= 1;
        }
        System.out.println("n: " + n + " layerCount: " + layerCount);

        for (int i = 0; i < layerCount; i++) {
            int width = n - (2 * i);
            System.out.println("width: " + width);
            int[] top = new int[width];
            for (int j = 0; j < width; j++) {
                top[j] = matrixInitial[i][i + j];
            }
            System.out.println("top: " + Arrays.toString(top));
            
            //OK TOP TO RIGHT
            
            for (int j = 0; j < width; j++) {
                matrixFinal[j+i][width-1+i] = top[j];
            }

            int[] tempLeft = new int[width];
            for (int j = 0; j < width; j++) {
                tempLeft[j] = matrixInitial[i + j][i];
            }

            int[] left = new int[width];
            int indexTemp = 0;
            for (int j = width-1; j >= 0; j--) {
                left[indexTemp++] = tempLeft[j];
            }
            System.out.println("left: " + Arrays.toString(left));

            //OK LEFT TO TOP
            
            for (int j = 0; j < width; j++) {
                matrixFinal[i][j + i] = left[j];
            }

            int[] bottom = new int[width];
            for (int j = 0; j < width; j++) {
                bottom[j] = matrixInitial[width - 1 + i][j + i];
            }
            System.out.println("bottom: " + Arrays.toString(bottom));

            //TODO BOTTOM TO LEFT
            
            for (int j = 0; j < width; j++) {
            	matrixFinal[j+i][i] = bottom[j];
            }
            
            int[] tempRight = new int[width];
            for (int j = 0; j < width; j++) {
                tempRight[j] = matrixInitial[j + i][width - 1 + i];
            }
            int[] right = new int[width];
            int indexTemp2 = 0;
            for (int j = width; j > 0; j--) {
                right[indexTemp2++] = tempRight[j - 1];
            }
            System.out.println("right: " + Arrays.toString(right));

            //OK RIGHT TO BOTTOM
            for (int j = 0; j < width; j++) {
                matrixFinal[width-1+i][j + i] = right[j];
            }

        }
        System.out.println(",,,,,,,,,,,,,,,,,");
        for (int i = 0; i < n; i++) {
        	System.out.println(Arrays.toString(matrixFinal[i]));
        }
        return matrixFinal;
    }

    private static int[][] initMatrix(int n) {
        int[][] matrix = new int[n][n];
        int fill = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = fill++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                System.out.println(i + " " + j + " " + matrix[i][j]);
            }
        }
        System.out.println("******");
        return matrix;
    }
   

}
