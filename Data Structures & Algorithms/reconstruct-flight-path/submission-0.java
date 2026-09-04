class Solution {
    LinkedList<String> ans ;
    Map<String, PriorityQueue<String>> map ;
    public List<String> findItinerary(List<List<String>> tickets) {
        this.ans = new LinkedList<>();
        this.map = new HashMap<>();

        for(List<String> s : tickets){
            map.computeIfAbsent(s.get(0), k -> new PriorityQueue<>()).add(s.get(1));
        }

        dfs("JFK");

        return ans;
    }

    public void dfs(String s){
        PriorityQueue<String> li = map.getOrDefault(s, new PriorityQueue<>());
        while(!li.isEmpty()){
            String temp = li.poll();
            dfs(temp);
        }
        ans.addFirst(s);
    }
}