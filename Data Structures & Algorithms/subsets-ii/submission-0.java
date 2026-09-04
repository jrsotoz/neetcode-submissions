class Solution {
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), 0);
        return list;
    }
    public void dfs(List<List<Integer>> list, List<Integer> l, int index){
        if(!list.contains(l))
            list.add(new ArrayList<>(l));

        for(int i = index ; i < nums.length ; i++){
            l.add(nums[i]);
            dfs(list, l, i + 1);
            l.remove(l.size() - 1);
        }
    }
}