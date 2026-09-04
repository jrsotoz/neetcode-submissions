class Solution {
    public int trap(int[] h) {
        int[] maxR = new int[h.length];
        int maxRtemp = 0;

        for(int i = h.length - 1 ; i >= 0 ; i--){
            maxRtemp = Math.max(maxRtemp, h[i]);
            maxR[i] = maxRtemp;
        }

        int ans = 0;
        int maxL = 0;

        for(int i = 0 ; i < h.length ; i++){
            maxL = Math.max(maxL, h[i]);
            ans += Math.min(maxL, maxR[i]) - h[i];
        }

        return ans;
    }
}
