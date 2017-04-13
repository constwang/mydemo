package algorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/4/10.
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) return result;
        int startCol = 0, endCol = matrix[0].length - 1;
        int startRow = 0, endRow = matrix.length - 1;
        while (startCol <= endCol && startRow <= endRow) {
            for (int i = startCol; i <= endCol; i++) {
                result.add(matrix[startRow][i]);
            }
            startRow++;
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    result.add(matrix[endRow][i]);
                }
            }
            endRow--;
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
            }
            startCol++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 3}};
        System.out.println(spiralOrder(matrix));
    }
}
