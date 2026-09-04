class Solution {
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int max = 0;

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        return max;
    }
    public int dfs(int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0;

        
        return 1 + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);

    }
}