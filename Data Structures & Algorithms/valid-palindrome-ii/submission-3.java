class Solution {
    public boolean validPalindrome(String s) {
        int left = 0 ; 
        int right = s.length() - 1;

        while(left < right){
            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if(c1 != c2){
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean isPalindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else return false;
        }
        return true;
    }
}