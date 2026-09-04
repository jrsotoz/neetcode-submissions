class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            left[i] = -1;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                left[i] = stack.peek();
            }

            stack.add(i);
        }

        stack.clear();

        for(int i = n - 1 ; i >= 0 ; i--){
            right[i] = n;

            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(!stack.isEmpty()){
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        for(int i = 0 ; i < n ; i++){
            left[i]++;
            right[i]--;
            max = Math.max(max, heights[i] * (right[i] - left[i] + 1));
        }

        return max;
    }
}