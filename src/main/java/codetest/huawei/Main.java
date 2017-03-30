package codetest.huawei;

import java.util.Scanner;

/**
 * Created by wangk on 2017/3/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {//注意while处理多个case
            String line=in.nextLine();
            int a = Integer.parseInt(line.split(",")[0]);
            int b = Integer.parseInt(line.split(",")[1]);
            //reverseAdd(a,b);
            System.out.println(reverseAdd(a,b));
        }
    }
    public static int reverseAdd(int a,int b){
        if((a<0||a>70000)||(b<0||b>70000)){
            return -1;
        }
        int a1=reverse(a);
        int b1=reverse(b);
        return a1+b1;
    }
    public static int reverse(int x){
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            int newResult = result * 10 + digit;
            if ((newResult - digit) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
