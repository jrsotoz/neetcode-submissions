class Solution {
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        return Math.max(Math.max(max(0, nums.length - 2), max(1, nums.length - 1)), nums[0]);
    }

    public int max(int start, int end){
        int s1 = 0;
        int s2 = 0;
        for(int i = start ; i <= end ; i++){
            int temp = Math.max(s1 + nums[i], s2);
            s1 = s2;
            s2 = temp;
        }
        return Math.max(s1, s2);
    }
}
