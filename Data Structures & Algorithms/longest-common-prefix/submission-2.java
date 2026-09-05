class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String one = strs[0];
        String last = strs[strs.length - 1];
        int i = 0 ;
        while(i < one.length()  && i < last.length() ){
            if(one.charAt(i) == last.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        return one.substring(0, i);
    }
}