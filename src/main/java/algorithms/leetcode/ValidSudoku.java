package algorithms.leetcode;

import java.util.HashSet;

/**
 * Created by wa on 2017/4/11.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> insideSet = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && rowSet.contains(board[i][j])) return false;
                else rowSet.add(board[i][j]);
                if (board[j][i] != '.' && colSet.contains(board[j][i])) return false;
                else colSet.add(board[j][i]);
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !insideSet.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
