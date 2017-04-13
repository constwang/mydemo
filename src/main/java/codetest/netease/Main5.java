package codetest.netease;

import java.util.Scanner;

/**
 * Created by wa on 2017/4/5.
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String s2 = in.nextLine();
            int n = Integer.parseInt(s2);
            long d[] = new long[n];//n children
            boolean dLoaded = false;


            long base = 1;
            long sum = 0;
            for (int j = 0; j < s.length(); j++) {
                base *= 10;
            }
            for (int i = 0; i < s.length(); i++) {
                base /= 10;
                if (s.charAt(i) == 'X') {
                    if (!dLoaded) {
                        long[] temp = new long[n];
                        for (int j = 0; j <= 9; j++) {
                            temp[(int) ((j * base) % n)]++;
                        }
                        System.arraycopy(temp, 0, d, 0, n);
                        dLoaded = true;
                        continue;
                    }
                    int[] mod = new int[10];
                    for (int j = 0; j <= 9; j++) {
                        mod[j] = (int) ((j * base) % n);
                    }
                    long[] newd = new long[n];
                    for (int m = 0; m < n; m++) {
                        for (int k = 0; k <= 9; k++) {
                            newd[m] += d[(n + m - mod[k]) %
                                    n];
                        }
                    }
                    System.arraycopy(newd, 0, d, 0, n);
                } else {
                    long a = (s.charAt(i) - '0') * base;
                    sum = (sum + a) % n;
                }
            }
            System.out.println(d[(int) ((n - sum) % n)]);
        }
    }
}
