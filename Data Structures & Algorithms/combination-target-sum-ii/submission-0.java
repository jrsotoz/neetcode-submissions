class Solution {
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);

        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>() , 0, 0);
        return list;
    }

    public void dfs(List<List<Integer>> list, List<Integer> l, int index, int sum){
        if(sum == target ){
            list.add(new ArrayList<>(l));
        }
        if(sum >= target){
            return;
        }
        for(int i = index ; i < candidates.length ; i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            int temp = candidates[i];
            l.add(temp);
            sum += temp;
            dfs(list, l, i + 1 , sum);
            l.remove(l.size() - 1);
            sum -= temp;
        }
    }
}