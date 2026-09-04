class Solution {
    public boolean isValidSudoku(char[][] board) {
        //check row
        for(int i = 0 ; i < 9 ; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                char aux = board[i][j];
                if(aux == '.') continue;
                if(set.contains(aux))
                    return false;
                set.add(aux);
            }
        }

        //check column
        for(int i = 0 ; i < 9 ; i++){
            Set<Character> column = new HashSet<>();
            for(int j = 0 ; j < 9 ; j++){
                char aux = board[j][i];
                if(aux == '.') continue;
                if(column.contains(aux)){
                    return false;
                }
                column.add(aux);
            }
        }

        for(int i = 0 ; i < board.length ; i += 3){
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < board[0].length ; j++){
                if(j % 3 == 0){
                    set.clear();
                }
                if(set.contains(board[i][j]) && board[i][j] != '.') return false;
                else set.add(board[i][j]);
                if(set.contains(board[i + 1][j]) && board[i + 1][j] != '.') return false;
                else set.add(board[i + 1][j]);
                if(set.contains(board[i + 2][j]) && board[i + 2][j] != '.') return false;
                else set.add(board[i + 2][j]);
            }
        }


        return true;
    }
}
