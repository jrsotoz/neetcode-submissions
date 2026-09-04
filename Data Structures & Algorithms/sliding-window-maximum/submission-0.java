class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> window = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];
        int pointer = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(!window.isEmpty() && window.peek() < i - k + 1 ){
                window.removeFirst();
            }

            while(!window.isEmpty() && nums[window.peekLast()] <= nums[i]){
                window.removeLast();
            }

            window.addLast(i);

            if(i >= k - 1){
                ans[pointer++] = nums[window.peek()];
            }
        }

        return ans;
    }
}
