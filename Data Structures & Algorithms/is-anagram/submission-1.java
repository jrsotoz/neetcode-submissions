class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        for(char i : s.toCharArray()){
            dict[i - 'a']++;
        }
        for(char i : t.toCharArray()){
            dict[i - 'a']--;
        }
        for(int i : dict){
            if(i != 0) return false;
        }

        return true;
    }
}
