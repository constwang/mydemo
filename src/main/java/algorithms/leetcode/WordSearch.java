package algorithms.leetcode;

/**
 * Created by wa on 2017/4/11.
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isExist(board, i, j, word.toCharArray(), 0)) return true;
            }
        }
        return false;
    }

    public static boolean isExist(char[][] board, int y, int x, char[] word, int index) {
        if (index == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[index]) return false;
        board[y][x] ^= 256;
        boolean result = isExist(board, y + 1, x, word, index + 1)
                || isExist(board, y - 1, x, word, index + 1)
                || isExist(board, y, x + 1, word, index + 1)
                || isExist(board, y, x - 1, word, index + 1);
        board[y][x] ^= 256;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(exist(board, "see"));
    }
}
