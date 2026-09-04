class Solution {
    public int characterReplacement(String s, int k) {
        int[] maxChar = new int[26];
        int longSize = 0;
        int max = 0;
        int l = 0;

        for(int r = 0 ; r < s.length() ; r++){
            char c = s.charAt(r);
            maxChar[c - 'A']++;
            max = Math.max(max, maxChar[c - 'A']);

            boolean isValid = r + 1 - l - max <= k;

            if(!isValid){
                char temp = s.charAt(l++);
                maxChar[temp - 'A']--;

            }

            longSize = Math.max(longSize, r + 1 - l);
        }


        return longSize;
    }
}
