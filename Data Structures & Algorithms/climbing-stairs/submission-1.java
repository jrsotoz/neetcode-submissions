class Solution {
    int[] cache;
    int n;
    public int climbStairs(int n) {
        this.cache = new int[n];
        this.n = n;
        for(int i = 0 ; i < n ; i++){
            cache[i] = -1;
        }
        return dfs(0);
    }
    public int dfs(int i){
        if(i >= n) return i == n ? 1 : 0;
        if(cache[i] != -1) return cache[i];

        cache[i] = dfs(i + 1) + dfs(i + 2);

        return cache[i];
    }
}