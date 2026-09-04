class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] ans = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            int pre = i == 0 ? 1 : prefix[i - 1];
            prefix[i] = pre * nums[i];
        }

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int post = i == nums.length - 1 ? 1 : postfix[i + 1];
            postfix[i] = nums[i] * post;
        }

        ans[0] = postfix[1];
        for(int i = 1 ; i < nums.length - 1; i++){
            ans[i] = prefix[i - 1] * postfix[i + 1];
        }
        ans[nums.length - 1] = prefix[nums.length - 1 - 1];

        return ans;
    }
}  
