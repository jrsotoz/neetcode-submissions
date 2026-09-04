class Solution {
    int[] piles;
    int h;
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length > h) return -1;
        this.piles = piles;
        this.h = h;
        
        int l = 1;
        int r = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i : piles){
            r = Math.max(r, i);
        }

        while(l <= r){
            int m = l + (r - l) / 2 ;
            if(check(m)){
                min = Math.min(min, m);
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public boolean check(int m){
        int hour = 0;

        for(int p : piles){
            int res = p % m > 0 ? 1 : 0;
            hour += p / m + res;

            if(hour > h){
                return false;
            }
        }

        return h >= hour;
    }
}
