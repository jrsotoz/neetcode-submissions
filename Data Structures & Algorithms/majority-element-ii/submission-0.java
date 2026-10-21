class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            if(!ans.contains(n)){
                int count = map.getOrDefault(n, 0) + 1;
                if(count > nums.length / 3) ans.add(n);
                map.put(n, count);
            }
        }
        return ans;
    }
}