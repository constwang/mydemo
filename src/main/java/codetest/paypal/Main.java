package codetest.paypal;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangk on 2017/4/13.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] aLine = in.nextLine().split(" ");
        String[] bLine = in.nextLine().split(" ");
        int[] a = new int[aLine.length];
        int[] b = new int[bLine.length];
        for (int i = 0; i < aLine.length; i++) {
            a[i] = Integer.parseInt(aLine[i]);
            b[i] = Integer.parseInt(bLine[i]);
        }
        System.out.println(result(a,b));
    }

    public static int result(int[] a, int[] b){
        int survivors = 0;
        Stack<Integer> ones = new Stack<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (b[i] == -1) {
                if (ones.size() == 0) {
                    survivors++;
                } else {
                    while (!ones.empty()) {
                        if (a[i] > ones.peek()) {
                            ones.pop();
                        } else {
                            break;
                        }
                    }
                    if (ones.empty()) {
                        survivors++;
                    }
                }
            } else {
                ones.push(a[i]);
            }
        }
        return survivors + ones.size();
    }
}
