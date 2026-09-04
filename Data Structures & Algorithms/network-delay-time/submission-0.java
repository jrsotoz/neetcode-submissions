class Solution {
    HashMap<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    public int networkDelayTime(int[][] times, int n, int k) {
        
        for(int[] time : times){
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new Pair(time[1], time[2]));
        }
        
        int[] nodes = new int[n + 1];
        Arrays.fill(nodes, Integer.MAX_VALUE);
        
        disk(nodes, n, k);
        int ans = Integer.MIN_VALUE;
        
        for(int i = 1; i < nodes.length ; i++)
            ans = Math.max(ans, nodes[i]);
        
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private void disk(int[] nodes, int n, int k){
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<Pair<Integer, Integer>>(Comparator.comparing(Pair::getValue));
        queue.add(new Pair(k, 0));
        
        nodes[k] = 0;
        
        while(!queue.isEmpty()){
            Pair<Integer, Integer> currNode = queue.remove();
            int current = currNode.getKey();
            int time = currNode.getValue();
            
            if(time > nodes[current])
                continue;
            if(!map.containsKey(current))
                continue;
            
            for(Pair<Integer, Integer> aux : map.get(current)){
                int next = aux.getKey();
                int newTime = aux.getValue() + time;
                if(nodes[next] > newTime){
                    nodes[next] = newTime;
                    queue.add(new Pair(next, newTime));
                }
            }
        }
        
    }
}