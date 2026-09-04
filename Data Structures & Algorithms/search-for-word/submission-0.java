class Solution {
    char[][] board;
    boolean[][] visited;
    char[] w;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.visited = new boolean[board.length][board[0].length];
        this.w = word.toCharArray();

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(w[0] == board[i][j] && dfs(i, j, 0)) return true;
            }
        }

        return false;
    }

    public boolean dfs(int x, int y, int pointer){
        if(pointer == w.length - 1 && w[pointer] == board[x][y]){
            return true;
        }
        if(w[pointer] != board[x][y]){
            return false;
        }

        visited[x][y] = true;

        if( (x - 1 >= 0 && !visited[x - 1][y] && dfs(x - 1, y , pointer + 1)) || 
            (x + 1 < board.length && !visited[x + 1][y] && dfs(x + 1, y , pointer + 1)) ) 
                return true;
        if( (y - 1 >= 0 && !visited[x][y - 1] && dfs(x, y - 1 , pointer + 1)) || 
            (y + 1 < board[0].length &&  !visited[x][y + 1] && dfs(x, y + 1, pointer + 1)) ) 
                return true;


        visited[x][y] = false;

        return false;
    }
}
