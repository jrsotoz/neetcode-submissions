class Solution {
    int[] nums;
    int target;
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int l = 0 ;
        int r = nums.length - 1;

        int start = findStart(l, r);

        if(target >= nums[start] && target <= nums[r] ){
            l = start ;
        }
        else{
            r = start - 1;
        }
        
        while(l <= r){
            int m = l + (r - l) / 2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }

    public int findStart(int l , int r){
        if(l >= r) return l;
        int m = l + (r - l) / 2;
        if(nums[m] > nums[r]){
            return findStart(m + 1, r);
        }else{
            return findStart(l, r - 1);
        }
    }
}
