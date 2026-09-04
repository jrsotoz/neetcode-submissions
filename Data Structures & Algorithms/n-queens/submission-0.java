class Solution {
    List<List<String>> ans;
    Set<Integer> col;
    Set<Integer> posDia;
    Set<Integer> negDia;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.ans = new ArrayList<>();
        this.col = new HashSet<>();
        this.posDia = new HashSet<>();
        this.negDia = new HashSet<>();
        char[][] board = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '.';
            }
        }    

        fillQueen(0, board);

        return ans;
    }

    public void fillQueen(int r, char[][] board){
        if(r == n){
            List<String> temp = new ArrayList<>();
            for(char[] c : board){
                temp.add(new String(c));
            }
            ans.add(temp);
            return;
        }

        for(int i = 0 ; i < n ; i++){
            if(col.contains(i) || posDia.contains(r + i) || negDia.contains(r - i)){
                continue;
            }

            board[r][i] = 'Q';
            col.add(i);
            posDia.add(r + i);
            negDia.add(r - i);

            fillQueen(r + 1, board);

            board[r][i] = '.';
            col.remove(i);
            posDia.remove(r + i);
            negDia.remove(r - i);

        }
    }
}