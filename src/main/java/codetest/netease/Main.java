package codetest.netease;

import java.util.Scanner;

/**
 * Created by wangk on 2017/3/25.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalNum = Integer.parseInt(in.nextLine());
        int[] x = new int[totalNum];
        int[] y = new int[totalNum];
        String[] xString = in.nextLine().split(" ");
        String[] yString = in.nextLine().split(" ");
        for (int i = 0; i < totalNum; i++) {
            x[i] = Integer.parseInt(xString[i]);
            y[i] = Integer.parseInt(yString[i]);
        }
        String[] G = in.nextLine().split(" ");
        int gx = Integer.parseInt(G[0]);
        int gy = Integer.parseInt(G[1]);
        String[] time = in.nextLine().split(" ");
        int walkTime = Integer.parseInt(time[0]);
        int taxiTime = Integer.parseInt(time[1]);
        int walkLength = Math.abs(gx) + Math.abs(gy);
        int mintime = walkLength * walkTime;
        for (int i = 0; i < totalNum; i++) {
            int cwalklength = Math.abs(x[i]) + Math.abs(y[i]);
            int ctaxiLength = Math.abs(gx - x[i]) + Math.abs(gy - y[i]);
            int timeCurrent = cwalklength * walkTime + ctaxiLength * taxiTime;
            if (timeCurrent < mintime) {
                mintime = timeCurrent;
            }
        }
        System.out.println(mintime);

    }


}
