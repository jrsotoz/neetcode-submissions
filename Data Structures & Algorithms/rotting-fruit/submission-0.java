class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }else if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dict = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(fresh > 0 && !queue.isEmpty()){
            int size = queue.size();

            for(int i = 0 ; i < size ; i++){
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];

                for(int[] d : dict){
                    int newX = x + d[0];
                    int newY = y + d[1];

                    if(newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] != 1){
                        continue;
                    }

                    grid[newX][newY] = 2;
                    queue.add(new int[]{newX, newY});
                    fresh--;
                }
            }

            time++;
        }

        return fresh > 0 ? -1 : time;
    }
}