class Solution {
    public int rob(int[] nums) {
        int n1 = 0;
        int n2 = 0;
        for(int i : nums){
            int temp = Math.max(n1 + i, n2);
            n1 = n2;
            n2 = temp;
        }
        return Math.max(n1, n2);
    }
}
