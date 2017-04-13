package algorithms.leetcode;

/**
 * Created by wa on 2017/4/12.
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] num = new int[m][n];
        for (int i = 0; i < n; i++) {
            num[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            num[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                num[i][j] = num[i - 1][j] + num[i][j - 1];
            }
        }
        return num[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(1, 2));
    }
}
