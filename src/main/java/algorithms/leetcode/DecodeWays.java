package algorithms.leetcode;

/**
 * Created by wa on 2017/4/18.
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] ways = new int[s.length()];
        char[] ch = s.toCharArray();
        ways[0] = 1;
        for (int i = 1; i < ch.length; i++) {
            if (ch[i - 1] == '0' && ch[i] == '0') return 0;
            ways[i] = ways[i - 1] + getWays(ch, i);
        }
        return ways[s.length() - 1];
    }

    public static int getWays(char[] ch, int i) {
        int result = (ch[i - 1] - '0') * 10 + ch[i] - '0';
        if (result % 10 == 0) return 0;
        else if (result >= 1 && result <= 26) return 1;
        else return 0;
    }

    public static int numDecodings2(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings2("1010"));
    }
}
