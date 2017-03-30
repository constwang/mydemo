package codetest.toutiao;

import java.util.*;

/**
 * Created by wangk on 2017/3/30.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line=in.nextLine().split(",");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        List<Map<String, Integer>> lineMap = new ArrayList<>(n);
        String[] lineString = new String[n];
        for (int i = 0; i < n; i++) {
            lineString[i] = in.nextLine();
            String[] wordsInput = lineString[i].split(" ");
            Map<String, Integer> words = new HashMap<>();
            for (String word : wordsInput) {
                Integer num = words.get(word);
                if (num == null) words.put(word, 1);
                else words.put(word, num + 1);
            }
            lineMap.add(words);
        }
        for (int i = 0; i < m; i++) {
            int matchNum = 0;
            int index = 0;
            String[] wordsInput = in.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                Map<String, Integer> real = new HashMap<>(lineMap.get(j));
                int tempMatchNum = 0;
                for (String word : wordsInput) {
                    Integer num = real.get(word);
                    if (num != null && num != 0) {
                        real.put(word, num - 1);
                        tempMatchNum++;
                    }
                }
                if (tempMatchNum > matchNum) {
                    matchNum = tempMatchNum;
                    index = j;
                }
            }
            System.out.println(lineString[index]);
        }
    }
}
