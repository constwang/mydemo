package codetest.netease;

import java.util.Scanner;

/**
 * Created by wangk on 2017/3/24.
 */
public class GentlePoint {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num=in.nextInt();
        double len=  Math.sqrt(num);
        int times=0;
        for(int i=0;i<len;i++){
            /*for (int j=len;j>0;j--){
                if (i*i+j*j==num){
                    times++;
                }
            }*/
            double j=Math.sqrt(num-i*i);
            if ((int)j==j){
                System.out.println(j);
                times++;
            }
        }
        System.out.println(times*4);
    }
}
