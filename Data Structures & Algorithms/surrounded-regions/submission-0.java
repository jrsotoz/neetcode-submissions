class Solution {
    int row;
    int col;
    char[][] board;
    public void solve(char[][] board) {
        this.board = board;
        this.row = board.length;
        this.col = board[0].length;

        for(int i = 0 ; i < col ; i++){
            if(board[0][i] == 'O') dfs(0, i);
            if(board[row - 1][i] == 'O') dfs(row - 1, i);
        }

        for(int i = 0 ; i < row ; i++){
            if(board[i][0] == 'O') dfs(i, 0);
            if(board[i][col - 1] == 'O') dfs(i ,col - 1);
        }

        for(int i = 0 ; i < row ; i++){
            for(int j = 0; j < col ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j){
        if(i < 0 || i >= row  || j < 0 || j >= col || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'T';

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}