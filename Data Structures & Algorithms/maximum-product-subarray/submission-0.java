class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProd = nums[0];

        for(int i = 1; i < nums.length ; i++){
            int temp = nums[i];
            int tempMax = Math.max(temp, Math.max(currentMax * temp, currentMin * temp));
            currentMin = Math.min(temp, Math.min(currentMax * temp, currentMin * temp));

            currentMax = tempMax;
            maxProd = Math.max(currentMax, maxProd);
        }

        return maxProd;
    }
}