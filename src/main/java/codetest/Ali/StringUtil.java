package codetest.Ali;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    /**
     * 返回子字符串 des 在 src 中出现的所有位置
     * 如果返回 List 为空则说明 des 不是 src 的子字符串
     * @param src
     * @param des
     * @return
     */
    public static List<Integer> indexOf(String src, String des) {
        if (src == null || des == null) {
            //输入字符串不能为空
            throw new IllegalArgumentException("parameter could not be null");
        }
        // res 保存所有子字符串出现的位置
        List<Integer> res=new ArrayList<>();
        char[] srcChars = src.toCharArray();
        char[] desChars = des.toCharArray();
        // 为空字符串时直接返回 0
        if ((srcChars.length == 0 && desChars.length == 0) || desChars.length == 0) {
            res.add(0);
            return res;
        }
        int index = 0;  //srcChars的数组下标
        while (index < srcChars.length) {
            //找到第一个字符
            if (srcChars[index] == desChars[0]) {
                int temp = index;
                int index2 = 0;     // desChars 的数组下标
                // 判断剩余字符串是否匹配
                while (temp < srcChars.length && index2 < desChars.length) {
                    if (srcChars[temp] != desChars[index2]) {
                        break;
                    }
                    temp++;
                    index2++;
                }
                // 匹配，将位置加入返回数组
                if (index2 == desChars.length) {
                    res.add(index);
                }
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
