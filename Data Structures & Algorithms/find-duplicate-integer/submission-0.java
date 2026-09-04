class Solution {
    public int findDuplicate(int[] nums) {
        int[] n = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            n[nums[i]]++;
            if(n[nums[i]] > 1){
                return nums[i];
            }
        }

        return -1;
    }
}