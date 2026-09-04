class Solution {
    public int[] dailyTemperatures(int[] t) {
        int[] ans = new int[t.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0 ; i < t.length ; i++){
            while(!stack.isEmpty() && t[stack.peek()] < t[i]){
                int temp = stack.pop();
                ans[temp] = i - temp;
            }

            stack.push(i);
        }

        return ans;
    }
}
