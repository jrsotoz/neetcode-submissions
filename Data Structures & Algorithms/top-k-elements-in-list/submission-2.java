class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        //Arrays.sort(nums);


        for(int i : nums){
            Integer count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()){
            Pair<Integer, Integer> pair = new Pair<>(m.getValue(), m.getKey());
            maxHeap.add(pair);
        }

        for(int i = k ; i > 0 ; i--){
            ans[i - 1] = maxHeap.remove().getValue();
        }

        return ans;


    }
}
