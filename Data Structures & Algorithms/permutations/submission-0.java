class Solution {
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>());
        return list;
    }
    public void dfs(List<List<Integer>> list , List<Integer> l){
        if(l.size() == nums.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i : nums){
            if(!l.contains(i)){
                l.add(i);
                dfs(list, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
