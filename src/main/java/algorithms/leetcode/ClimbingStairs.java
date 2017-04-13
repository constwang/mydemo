package algorithms.leetcode;

/**
 * Created by wa on 2017/4/12.
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int before = 1;
        int after = 2;
        int totalWays = 0;
        for (int i = 3; i <= n; i++) {
            totalWays = before + after;
            before = after;
            after = totalWays;
        }
        return totalWays;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }

}
