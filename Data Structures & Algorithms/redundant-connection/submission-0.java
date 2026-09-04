class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        this.parent = new int[edges.length + 1];
        for(int i = 0 ; i < edges.length ; i++){
            parent[i] = i;
        }
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u) == find(v)){
                return edge;
            }

            union(u, v);
        }
        return new int[0];
    }
    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y){
        int pX = find(x);
        int pY = find(y);
        parent[pX] = pY;
    }
}
