package algorithms.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by wa on 2017/4/13.
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> rows = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < matrix[row].length; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }

    public static void set(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
