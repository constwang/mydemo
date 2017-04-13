package codetest.tencent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int line=in.nextInt();
            int[] total=new int[line];
            int[] local=new int[line];
            for(int i=0;i<line;i++){
                total[i]=in.nextInt();
                local[i]=in.nextInt();
            }
            for(int i=0;i<line;i++){
                int n=total[i];
                int m=local[i];
                int t=n-m;
                double p=t/(n*1.0);
                double pp=1.0;

                p=p*pp;
//                while(t>=0){
//                    double pp=(t/2)/(n*1.0);
//                    p=p*pp;
//                    t--;
//                    n--;
//                }
                while(n>1){
                    if(m%2==0){
                    pp=(m/2)/(m*1.0);
                     }else{pp=(m/2-1)/(m*1.0);
                    }
                    n--;
                }
                System.out.println(p);
            }
        }
    }
}
