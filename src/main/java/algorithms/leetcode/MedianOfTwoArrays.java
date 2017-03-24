package algorithms.leetcode;

/**
 * Created by wangk on 2017/3/10.
 */
public class MedianOfTwoArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalSize=nums1.length+nums2.length;
        int middleIndex=(totalSize-1)/2;
        int i = 0,j = 0;

        while (i<nums1.length||j<nums2.length){
            if (i+j==middleIndex){
                break;
            }else {
                if (nums1[i]<nums2[j]){
                    if (i<nums1.length){
                        i++;
                    }else {
                        j++;
                    }
                }else if (nums1[i]>nums2[j]){
                    if (j<nums2.length){
                        j++;
                    }else {
                        i++;
                    }
                }
            }
        }
        if (totalSize%2==0){
            return 0;
        }else {
            return Math.max(nums1[i],nums2[j]);
        }
    }
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
}
