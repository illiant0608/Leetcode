/**
 * leetcode 72
 *
 *  ------------------------
 * |  replace   |  insert   |
 * |------------------------|
 * |  delete    |     *     |
 *  ------------------------
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] matrix = new int[word1.length()+1][word2.length()+1];

        for (int i = 0;i < matrix.length;i++)
            matrix[i][0] = i;

        for (int i = 0;i < matrix[0].length;i++)
            matrix[0][i] = i;

        for (int i = 0;i < word1.length();i++) {
            for (int j = 0;j < word2.length();j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    matrix[i+1][j+1] = matrix[i][j]; // 不需要修改
                else
                    matrix[i+1][j+1] = getMin(matrix[i][j], matrix[i+1][j], matrix[i][j+1]) + 1;
            }
        }

        return matrix[word1.length()][word2.length()];
    }

    private int getMin(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        EditDistance test = new EditDistance();
        System.out.println();
    }
}
