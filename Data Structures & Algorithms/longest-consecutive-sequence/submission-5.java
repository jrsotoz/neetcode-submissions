class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num = new HashSet<>();
        for(int x : nums)
            num.add(x);
        int best = 0;
        for(int x : nums){
            if(!num.contains(x - 1)){
                int len = 1;
                while(num.contains(x + len)){
                    len++;
                }
                best = Integer.max(best,len);
            }
        }
        return best;
    }
}
