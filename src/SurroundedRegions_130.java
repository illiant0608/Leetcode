public class SurroundedRegions_130 {
    public void solve(char[][] board) {
        //没法靠旋转着的循环做
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;

        int m = board.length, n = board[0].length;

        //从第一列到最后一列
        for (int i = 0;i < m;i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i , 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n - 1);
        }

        //从第一行到做后一行
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }

        for (int i = 0;i < m ;i++) {
            for (int j = 0;j < n ;j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }



    }

    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i - 1][j] == 'O')
            boundaryDFS(board, i - 1, j);
        if (i < board.length - 2 && board[i + 1][j] == 'O')
            boundaryDFS(board, i + 1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j - 1);
        if (j < board[i].length - 2 && board[i][j + 1] == 'O')
            boundaryDFS(board, i, j + 1);
    }

    public boolean notSurrounded (char[][] board, int row, int col) {
        if (row == 0 || row == board.length - 1 || col == 0 || col == board[0].length - 1)
            return true;
        else {
            return board[row - 1][col] == '.' || board[row + 1][col] == '.' || board[row][col - 1] == '.' || board[row][col + 1] == '.';
        }
    }

    public static void main (String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        SurroundedRegions_130 test = new SurroundedRegions_130();
        test.solve(board);
    }
}
