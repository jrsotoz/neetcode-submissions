class Solution {
    int[][] land;
    int m;
    int n;
    int[][] dict;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.land = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        this.dict = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //fill horizontal
        for(int i = 0 ; i < n ; i++){
            if(!pacific[0][i])      dfs(0, i, pacific);
            if(!atlantic[m - 1][i]) dfs(m - 1, i, atlantic);
        }

        //fill vertical 
        for(int i = 0 ; i < m ; i++){
            if(!pacific[i][0])      dfs(i, 0, pacific);
            if(!atlantic[i][n - 1]) dfs(i, n - 1, atlantic);  
        }

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }

        return ans;
    }

    public void dfs(int i, int j, boolean[][] ocean){
        ocean[i][j] = true;

        for(int[] d : dict){
            int x = i + d[0];
            int y = j + d[1];

            if(x < 0 || x >= m || y < 0 || y >= n){
                continue;
            }else if(ocean[x][y]){
                continue;
            }else if(land[x][y] < land[i][j]){
                continue;
            }
            dfs(x, y, ocean);
        }
    }
}