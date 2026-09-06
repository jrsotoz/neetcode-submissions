class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int carry = 0;
        String first = strs[0];
        String last = strs[strs.length - 1];
        while(carry < first.length() && carry < last.length()){
            if(first.charAt(carry) == last.charAt(carry)){
                carry++;
            }else{
                break;
            }
        }
        return first.substring(0, carry);
    }
}