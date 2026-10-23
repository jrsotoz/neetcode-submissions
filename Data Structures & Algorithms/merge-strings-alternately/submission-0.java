class Solution {
    public String mergeAlternately(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        StringBuilder sb = new StringBuilder();

        int l = 0 ; 
        int r = 0 ;

        while(sb.length() < w1 + w2){
            if(l < w1){
                sb.append(word1.charAt(l++));
            }
            if(r < w2){
                sb.append(word2.charAt(r++));
            }
        }

        return sb.toString();
        
    }
}