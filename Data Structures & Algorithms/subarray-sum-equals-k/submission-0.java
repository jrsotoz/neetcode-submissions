class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        int last = 0;
        int count = 0;
        seen.put(0 , 1);

        for(int n : nums){
            last += n;
            count += seen.getOrDefault(last - k, 0);
            seen.put(last, seen.getOrDefault(last, 0) + 1);
        }

        return count;
    }
}