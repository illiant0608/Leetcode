import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2_212 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (!set.contains(word)) { //保证list里没有重复的word
                for (int i = 0;i < board.length;i++)
                    for (int j = 0;j < board[0].length;j++)
                        if (board[i][j] == word.charAt(0) && exist(board, i, j, word.toCharArray(), 0)) {
                            set.add(word);
                            list.add(word);
                            i = board.length; // 结束外层循环
                            break; //结束内层循环
                            // 找到一个单词后就应该直接退出两层循环，寻找下一个单词
                        }
            }
        }
        return list;
    }

    boolean exist(char[][] board, int i, int j, char[] word, int k) {
        if (k == word.length) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return false;
        if (board[i][j] != word[k]) return false;
        board[i][j] ^= 256;
        boolean exist = exist(board, i, j+1, word, k+1) || exist(board, i, j-1, word, k+1)
                || exist(board, i-1, j, word, k+1) || exist(board, i+1, j, word, k+1);
        board[i][j] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}};
        String[] words = {"a"};
        WordSearch2_212 test = new WordSearch2_212();
        System.out.println(test.findWords(board, words).size());
    }
}
