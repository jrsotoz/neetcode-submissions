class Solution {
    public int swimInWater(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[][] dict = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};


        queue.add(new int[]{grid[0][0],0,0});

        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int w = current[0];
            int x = current[1];
            int y = current[2];

            if(x == n - 1 && y == m - 1){
                return w;
            }

            visited[x][y] = true;

            for(int[] d : dict){
                int nx = x + d[0];
                int ny = y + d[1];

                if(isValid(nx, ny, n, m) && !visited[nx][ny]){
                    int newCost = Math.max(w, grid[nx][ny]);
                    queue.add(new int[]{newCost, nx, ny});
                }
            }
        }

        return max;
    }

    public boolean isValid(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}