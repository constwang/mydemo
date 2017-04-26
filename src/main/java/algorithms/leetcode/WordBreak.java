package algorithms.leetcode;

import java.util.List;

/**
 * Created by wa on 2017/4/21.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.indexOf(wordDict.get(i)) == 0) {
                // TODO: 2017/4/21
            }
        }
        return true;
    }
}
