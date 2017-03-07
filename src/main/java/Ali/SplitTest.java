package Ali;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wa on 2017/3/3.
 */
public class SplitTest {

    interface Test {
        void pring();
    }

    public static boolean judge(int[] A) {
        List<Test> f = new ArrayList<>();
        if (A.length < 7) {
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        int sum1 = A[i];
        int sum4 = A[j];
        int sum2 = 0;
        int sum3 = 0;

        while (j - i > 3) {
            if (sum1 < sum4) {
                i++;
                sum1 += A[i];
            } else if (sum1 > sum4) {
                j--;
                sum4 += A[j];
            } else {
                i += 2;
                j -= 2;
//                int a=i+2;
//                int b=j-2;
                sum2 = A[i];
                while (i < j + 1) {
                    if (sum2 != sum1) {
                        i++;
                        sum2 += A[i];
                    } else {
                        i += 2;
                        while (i <= j) {
                            sum3 += A[i];
                            i++;
                        }
                        if (sum3 == sum2) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{10, 2, 11, 13, 1, 1, 1, 1, 1};
        System.out.println(judge(A));
        ArrayList<String> strings=new ArrayList<>();
    }
}
