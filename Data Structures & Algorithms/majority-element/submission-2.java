class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int temp = nums[0];
        int maxRep = 1;

        for(int i = 1 ; i < nums.length ; i++){
            if(maxRep > nums.length / 2 ) return temp;
            if(nums[i] == temp) maxRep++;
            else{
                temp = nums[i];
                maxRep = 1;
            }
        }

        return temp;

    }
}