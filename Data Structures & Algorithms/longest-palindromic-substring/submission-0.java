class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int ansLength = 0;

        for(int i = 0 ; i < s.length() ; i++){
            int l = i ; 
            int r = i ;

            while(l >= 0 && r < s.length() && s.charAt(l) == (s.charAt(r))){
                if(r - l + 1 > ansLength){
                    ans = s.substring(l, r + 1);
                    ansLength = r - l + 1;
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            
            while(l >= 0 && r < s.length() && s.charAt(l) == (s.charAt(r))){
                if(r - l + 1 > ansLength){
                    ans = s.substring(l, r + 1);
                    ansLength = r - l + 1;
                }
                l--;
                r++;
            }
        }


        return ans;
    }
}