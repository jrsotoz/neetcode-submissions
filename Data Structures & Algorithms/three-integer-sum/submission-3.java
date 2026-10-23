class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        

        for(int i = 0 ; i < nums.length - 2 ; i++){
            int l = i + 1 ;
            int r = nums.length - 1;

            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue; 

            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    List<Integer> a = new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[l]);
                    a.add(nums[r]); 
                    ans.add(a);
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                }else if(sum > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }

        return ans;
    }
}
