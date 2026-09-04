class Solution {
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), 0);
        return list;
    }
    public void dfs(List<List<Integer>> list, List<Integer> l, int index){
        list.add(new ArrayList<>(l));
        for(int i = index ; i < nums.length ; i++){
            l.add(nums[i]);
            dfs(list, l, i + 1);
            l.remove(l.size() - 1);
        }
    }
}
