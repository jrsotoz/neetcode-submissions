class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int ans = 0;
        int n = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            int x = points[i][0];
            int y = points[i][1];
            for(int j = i + 1 ; j < n ; j++){
                int nx = points[j][0];
                int ny = points[j][1];
                int cost = Math.abs((nx - x)) + Math.abs(ny - y);

                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{cost, j});
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{cost, i});
            }
        }

        queue.add(new int[]{0,0});

        while(visited.size() < n){
            int[] current = queue.poll();
            int cost = current[0];
            int node = current[1];

            if(visited.contains(node)){continue;}

            visited.add(node);
            ans += cost;

            for(int[] l : map.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(l[1])){
                    queue.add(new int[]{l[0],l[1]});
                }
            }
        }




        return ans;
    }
}