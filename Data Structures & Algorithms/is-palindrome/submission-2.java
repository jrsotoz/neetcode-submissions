class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();

        for(Character c : s.toCharArray()){
            if(Character.isLetterOrDigit(c))
                sb.append(c);
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}
