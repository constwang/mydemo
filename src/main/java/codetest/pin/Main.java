package codetest.pin;

/**
 * Created by wa on 2017/4/12.
 */
public class Main {
    public static void spiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int startCol = 0, endCol = matrix[0].length - 1;
        int startRow = 0, endRow = matrix.length - 1;
        while (startCol <= endCol && startRow <= endRow) {
            for (int i = startCol; i <= endCol; i++) {
                matrix[startRow][i] = num++;
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = num++;
            }
            endCol--;
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    matrix[endRow][i] = num++;
                }
            }
            endRow--;
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    matrix[i][startCol] = num++;
                }
            }
            startCol++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                if (j != matrix.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        spiralMatrix(4);
    }
}
