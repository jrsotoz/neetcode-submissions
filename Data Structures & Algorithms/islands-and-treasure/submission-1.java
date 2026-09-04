class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dict = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] cel = queue.poll();
            int i = cel[0];
            int j = cel[1];

            for(int[] d : dict){
                int newI = d[0] + i;
                int newJ = d[1] + j;

                if(newI < 0 || newI >= n || newJ < 0 || newJ >= m || grid[newI][newJ] != Integer.MAX_VALUE){
                    continue;
                }

                grid[newI][newJ] = grid[i][j] + 1;

                queue.add(new int[]{newI, newJ});
            }
        }
    }
}
