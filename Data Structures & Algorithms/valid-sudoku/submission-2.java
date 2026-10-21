class Solution {
    public boolean isValidSudoku(char[][] board) {

        //horizontal
        for(int i = 0 ; i < 9 ; i++){
            int[] hor = new int[9];
            for(int j = 0 ; j < 9 ; j++){
                char val = board[i][j];
                if(val != '.'){
                    int c = val - '0' - 1;
                    if(hor[c] > 0) return false;
                    hor[c]++;
                }
            }
        }
        //vertical
        for(int i = 0 ; i < 9 ; i++){
            int[] ver = new int[9];
            for(int j = 0 ; j < 9 ; j++){
                char val = board[j][i];
                if(val != '.'){
                    int c = val - '0' - 1;
                    if(ver[c] > 0) return false;
                    ver[c]++;
                }
            }
        }

        //square  
        for (int box = 0; box < 9; box++) {
            Set<Integer> temp = new HashSet<>();
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            for (int r = startRow; r < startRow + 3; r++) {
                for (int c = startCol; c < startCol + 3; c++) {
                    char v = board[r][c];
                    if (v == '.') continue;
                    if (!temp.add(v - '0')) return false; // add() regresa false si ya existía
                }
            }
        }

        return true;
    }
}
