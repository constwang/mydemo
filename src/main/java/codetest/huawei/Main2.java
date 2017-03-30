package codetest.huawei;

import java.util.Scanner;

/**
 * Created by wangk on 2017/3/24.
 */
public class Main2 {
    public static void main(String[] args){
        int[] result={1,2,3,4,5,6};
        //String a="RA";

        Scanner in = new Scanner(System.in);
        //while (in.hasNextLine()) {//注意while处理多个case
            String line=in.nextLine();
            for (int i=0;i<line.length();i++){
                reverse(result,line.charAt(i));
            }
            for (int i=0;i<result.length;i++){
                System.out.print(result[i]);
            }
            System.out.println();
            //reverseAdd(a,b);
            //System.out.println(reverseAdd(a,b));
       // }
    }
    public static void reverse(int[] result, char ch){
        if (ch=='L'){
            int temp=result[0];
            result[0]=result[4];
            result[4]=result[1];
            result[1]=result[5];
            result[5]=temp;
        }
        if (ch=='R'){
            int temp=result[0];
            result[0]=result[5];
            result[5]=result[1];
            result[1]=result[4];
            result[4]=temp;
        }
        if (ch=='F'){
            int temp=result[2];
            result[2]=result[4];
            result[4]=result[3];
            result[3]=result[5];
            result[5]=temp;
        }
        if (ch=='B'){
            int temp=result[2];
            result[2]=result[5];
            result[5]=result[3];
            result[3]=result[4];
            result[4]=temp;
        }
        if (ch=='A'){
            int temp=result[2];
            result[2]=result[0];
            result[0]=result[3];
            result[3]=result[1];
            result[1]=temp;
        }
        if (ch=='C'){
            int temp=result[0];
            result[0]=result[2];
            result[2]=result[1];
            result[1]=result[3];
            result[3]=temp;
        }
    }

}
