package codetest.tencent;

import java.io.*;
import java.util.BitSet;

/**
 * Created by 王康 on 2017/8/3.
 */
public class Solution {

    public static int getTotalNum(String fileName) throws IOException {
        int totalNum = 0;
        //从文件中读取内容
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        BitSet positive = new BitSet();  //存放hashcode为正数的bitset
        BitSet negtive = new BitSet();   //存放hashcode为负数的bitset
        while ((line = reader.readLine()) != null) {
            int hashCode = line.hashCode();
            if (hashCode >= 0) {
                if (!positive.get(hashCode)) {
                    //如果当前位未被占用则计数并设定为1
                    positive.set(hashCode);
                    totalNum++;
                }
            } else {
                hashCode = -hashCode;
                if (!negtive.get(hashCode)) {
                    negtive.set(hashCode);
                    totalNum++;
                }
            }
        }
        return totalNum;
    }

    public static int getTotalNum2(String fileName) throws IOException {
        int totalNum = 0;
        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        //存储hashcode需要的最大int数组，两个数组共占用512MB内存
        int arraySize = Integer.MAX_VALUE / 32 + 1;
        int[] positive = new int[arraySize];    //hashcode为正数时放入该数组对应的位
        int[] negative = new int[arraySize];     //hashcode为负数时放入该数组对应的位
        while ((line = reader.readLine()) != null) {
            int hashCode = line.hashCode();
            if (hashCode >= 0) {
                int arrayIndex = hashCode / 32;     //放入数组的位置
                int bitIndex = hashCode % 32;       //放入对应的位
                int tmpNum = 1 << (bitIndex - 1);   //对应的位为1时对应的int大小
                int res = positive[arrayIndex] | tmpNum;    //进行与操作判断该位是否已经是1
                if (res != positive[arrayIndex]) {
                    //该位不为1，将该位置1并计数
                    positive[arrayIndex] = res;
                    totalNum++;
                }
            } else {
                hashCode = -hashCode;
                int arrayIndex = hashCode / 32;
                int bitIndex = hashCode % 32;
                int tmpNum = 1 << (bitIndex - 1);
                int res = negative[arrayIndex] | tmpNum;
                if (res != negative[arrayIndex]) {
                    negative[arrayIndex] = res;
                    totalNum++;
                }
            }
        }
        return totalNum;
    }


    public static void main(String[] args) {
        System.out.println("afadsfa".hashCode());
        long maxvalue = Integer.MAX_VALUE;
        maxvalue *= 2;
        System.out.println(-maxvalue);


    }
}
