class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int total = Integer.MIN_VALUE;
        for(int i : prices){
            min = Math.min(min, i);
            total = Math.max(total, i - min);
        }

        return total;
    }
}
