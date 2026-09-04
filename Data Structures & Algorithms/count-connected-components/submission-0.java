class Solution {
    Set<Integer> visited;
    List<List<Integer>> edge;
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        this.visited = new HashSet<>();
        this.edge = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) edge.add(new ArrayList<>());

        for(int i = 0 ; i < edges.length ; i++){
            edge.get(edges[i][0]).add(edges[i][1]);
            edge.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i = 0 ; i < n ; i++){
            if(!visited.contains(i)){
                dfs(i);
                ans++;
            }
        }

        return ans;
    }
    public void dfs(int i){
        if(visited.contains(i)){
            return;
        }
        visited.add(i);

        for(int l : edge.get(i)){
            dfs(l);
        }
    }
}
