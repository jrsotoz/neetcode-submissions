class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<List<int[]>> list = new ArrayList<>(); //[cost, node, steps]
        int[] minSteps = new int[n];

        for(int i = 0 ; i < n ; i++) list.add(new ArrayList<>());

        for(int[] f : flights){
            list.get(f[0]).add(new int[]{f[2], f[1]});
        }

        Arrays.fill(minSteps, Integer.MAX_VALUE);

        queue.add(new int[]{0, src, 0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cost = current[0];
            int node = current[1];
            int steps = current[2];

            if(node == dst){
                return cost;
            }

            if(steps > k){
                continue;
            }
            if(steps >= minSteps[node]){
                continue;
            }

            minSteps[node] = steps;

            for(int[] i : list.get(node)){
                int newNode = i[1];
                int newCost = i[0] + cost;
                queue.add(new int[]{newCost, newNode, steps + 1});
            }
        }


        return -1;
    }
}