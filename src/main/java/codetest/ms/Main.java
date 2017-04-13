package codetest.ms;

import java.util.Scanner;

/**
 * Created by wa on 2017/4/3.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //line=line.toUpperCase();
        int totalnum = line.length() / 16;
        for (int i = 0; i < totalnum; i++) {
            String hex = Integer.toHexString(i);
            for (int j = 0; j < 8 - hex.length(); j++) {
                System.out.print("0");
            }
            System.out.print(hex + "  ");
            for (int j = i; j < (i + 1) * 16; j++) {
                System.out.print(Integer.toHexString(line.charAt(j)) + " ");
            }
            System.out.println(line.substring(i * 16, (i + 1) * 16));
        }
    }
}
