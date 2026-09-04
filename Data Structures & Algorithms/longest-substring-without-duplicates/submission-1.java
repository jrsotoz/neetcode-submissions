class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int size = 0;
        int l = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char temp = s.charAt(i);
            
            while(set.contains(temp)){
                set.remove(s.charAt(l++));
            }

            set.add(temp);
            size = Math.max(size, set.size());
        }

        return size;
    }
}
