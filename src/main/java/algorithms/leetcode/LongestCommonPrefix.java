package algorithms.leetcode;

/**
 * Created by wangk on 2017/3/24.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int charIndex=-1;
        int arrayIndex=0;
        int minLength=strs[0].length();
        while(arrayIndex<minLength){
            for(int i=0;i<strs.length;i++){
                if(strs[i].length()<minLength){
                    minLength=strs[i].length();
                }
                //if(strs[i].charAt(i)!=strs[i].charAt(0))
            }
        }
        return null;
    }

    public static String betterSolution(String[] strs){
        if (strs.length==0){
            return "";
        }
        String pre=strs[0];
        int index=1;
        while (index<strs.length){
            while (strs[index].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
            }
            index++;
        }
        return pre;
    }
}
