package codetest.jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wa on 2017/4/7.
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int n = 4;
        int[] probability = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            //probability[i] = scanner.nextInt();
            temp[i] = i;
            probability[i] = 50;
        }

        List<List<Integer>> result = permute(temp, 3);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums, int targetLength) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0, targetLength);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start, int targetLength) {
        if (tempList.size() < targetLength) {
            list.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1, targetLength);
            tempList.remove(tempList.size() - 1);
        }

    }
}
