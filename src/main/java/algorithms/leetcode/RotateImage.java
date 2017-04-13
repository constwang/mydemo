package algorithms.leetcode;

import java.util.Arrays;

/**
 * Created by wa on 2017/4/5.
 */
public class RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int startRow = 0, endRow = n - 1;
        while (startRow < endRow) {
            int[] temp = matrix[startRow];
            matrix[startRow] = matrix[endRow];
            matrix[endRow] = temp;
            startRow++;
            endRow--;
        }
        //System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
