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

        for(int i = 0 ; i < 9 ; i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0 ; j < 3 ; j++){
                for(int k = 0 ; k < 3 ; k++){
                    int r = (i / 3) * 3 + j;
                    int c = (i % 3) * 3 + k;
                    if(board[r][c] == '.') continue;
                    if(set.contains(board[r][c])) return false;
                    set.add(board[r][c]);
                }
            }
        }


        return true;
    }
}
