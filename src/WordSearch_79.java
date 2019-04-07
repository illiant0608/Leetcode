import java.lang.reflect.Array;
import java.util.Arrays;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {
        char[] word_arr = word.toCharArray();
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (board[i][j] == word_arr[0])
//                    if (dfs(board, i, j, word_arr[0] + "", word))
//                        return true;
                    if (exist(board, i, j, word_arr, 0)) return true;
            }
        }

        return false;
    }

//    static char[][] copy(char[][] board) {
//        char[][] deepCopy = new char[board.length][board[0].length];
//        for (int i = 0;i < board.length;i++)
//            deepCopy[i] = Arrays.copyOf(board[i], board[i].length);
//        return deepCopy;
//    }



    boolean dfs (char[][] board, int i, int j, String current_word, String target_word) {
        char temp = board[i][j]; // 要把board[i][j]保存下来，用来恢复board
        board[i][j] = '#';
        if (current_word.equals(target_word)) return true;

        char target = target_word.charAt(current_word.length());
        String sub = target_word.substring(0, current_word.length() + 1);

        if (i > 0 && board[i-1][j] == target
            && dfs(board, i - 1, j, sub, target_word)){
            return true;
        }

        if (i < board.length - 1 && board[i+1][j] == target
            && dfs(board, i + 1, j, sub, target_word)) {
            return true;
        }

        if (j > 0 && board[i][j-1] == target
            && dfs(board, i, j - 1, sub, target_word)) {
            return true;
        }

        if (j < board[0].length - 1 && board[i][j+1] == target
                && dfs(board, i, j + 1, sub, target_word)) {
            return true;
        }

        board[i][j] = temp;

        return false;
    }

    // easier version
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
        char[][] board = {
                "ABCE".toCharArray(),
                "SFES".toCharArray(),
                "ADEE".toCharArray()
        };
        WordSearch_79 test = new WordSearch_79();
        System.out.println(test.exist(board, "ABCESEEEFS"));
    }
}
