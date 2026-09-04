class Solution {
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        List<List<Integer>> list = new ArrayList<>();

        dfs(list, new ArrayList<>(), 0, 0);

        return list;       
    }
    public void dfs(List<List<Integer>> list, List<Integer> l , int index, int sum){
        if(sum == target){
            list.add(new ArrayList<>(l));
        }
        if(sum >= target){
            return;
        }

        for(int i = index ; i < candidates.length ; i++){
            l.add(candidates[i]);
            sum += candidates[i];
            dfs(list, l, i, sum);
            l.remove(l.size() - 1);
            sum -= candidates[i];
        }
    }
}