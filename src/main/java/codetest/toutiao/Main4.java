package codetest.toutiao;

import java.util.List;
import java.util.Scanner;

/**
 * Created by wangk on 2017/3/30.
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] first = in.nextLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int q = Integer.parseInt(first[1]);
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            A[i][1] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int matchNum = 0;
            for (int j = 0; j < n; j++) {
                if (A[j][0] >= x && A[j][1] >= y) {
                    matchNum++;
                }
            }
            System.out.println(matchNum);
        }
    }
}
