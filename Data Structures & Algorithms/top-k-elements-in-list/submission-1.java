class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
        new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        maxHeap.addAll(map.entrySet());

        for(int i = 0 ; i < k ; i++){
            ans[i] = maxHeap.remove().getKey();
        }

        return ans;
    }
}
