class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0 ; i < n ; i++) list.add(new ArrayList<>());

        for(int[] i : edges){
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }

        if(!dfs(-1, 0, visited, list)){
            return false;
        }


        return visited.size() == n;

    }

    public boolean dfs(int prev, int current, Set<Integer> visited, List<List<Integer>> list){
        if(visited.contains(current)) return false;

        visited.add(current);

        for(int i : list.get(current)){
            if(i == prev) continue;
            if(visited.contains(i)) return false;
            if(!dfs(current, i, visited, list)){
                return false;
            }
        }

        return true;
    }
}