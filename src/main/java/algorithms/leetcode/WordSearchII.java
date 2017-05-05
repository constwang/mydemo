package algorithms.leetcode;

import algorithms.linked.ListNode;

import java.util.*;

/**
 * Created by wa on 2017/5/3.
 */
public class WordSearchII {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String val;
    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.val = word;
        }
        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                isExist(board, root, i, j, res);
            }
        }
        return res;
    }

    public static void isExist(char[][] board, TrieNode node, int i, int j, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return;
        char c = board[i][j];
        if (c > 'z' || node.next[c - 'a'] == null) return;
        node = node.next[c - 'a'];
        if (node.val != null) {
            res.add(node.val);
            node.val = null;
        }
        board[i][j] ^= 256;
        isExist(board, node, i - 1, j, res);
        isExist(board, node, i + 1, j, res);
        isExist(board, node, i, j - 1, res);
        isExist(board, node, i, j + 1, res);
        board[i][j] ^= 256;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(chars, words));
    }
}
