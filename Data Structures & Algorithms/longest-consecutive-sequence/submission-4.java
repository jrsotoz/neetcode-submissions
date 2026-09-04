class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int[] secuence = new int[nums.length];
        int max = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(i == 0 || nums[i] - nums[i - 1] > 1) secuence[i] = 1;
            else if(nums[i] == nums[i - 1]) secuence[i] = secuence[i - 1];
            else{
                secuence[i] = secuence[i - 1] + 1;
            }

            max = Math.max(max, secuence[i]);
        }

        return max;        
    }
}
