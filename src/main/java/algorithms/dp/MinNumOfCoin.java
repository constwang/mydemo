package algorithms.dp;

/**
 * Created by wa on 2017/4/3.
 * http://www.hawstein.com/posts/dp-novice-to-advanced.html
 */
public class MinNumOfCoin {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + ":" + getMinNum(i));
        }

    }

    public static int getMinNum(int num) {
        int[] nums = new int[num + 1];
        nums[0] = 0;
        for (int i = 1; i < num + 1; i++) {
            if (i == 1) nums[i] = 1;
            if (i == 2) nums[i] = 2;
            if (i >= 3 && i < 5) {
                int x1 = nums[i - 3] + 1;
                int x2 = nums[i - 1] + 1;
                nums[i] = Math.min(x1, x2);
            }
            if (i >= 5) {
                int x1 = nums[i - 5] + 1;
                int x2 = nums[i - 3] + 1;
                int x3 = nums[i - 1] + 1;
                nums[i] = Math.min(Math.min(x1, x2), x3);
            }
        }
        return nums[num];
    }


}
