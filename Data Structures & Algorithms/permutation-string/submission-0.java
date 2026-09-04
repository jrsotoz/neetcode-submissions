class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

        int size = s1.length();
        char[] s1Array = s1.toCharArray();

        Arrays.sort(s1Array);
        s1 = String.valueOf(s1Array);

        for(int i = 0 ; i <= s2.length() - size ; i++){
            char[] s2Array = s2.substring(i, i + size).toCharArray();
            Arrays.sort(s2Array);
            String temp = String.valueOf(s2Array);

            if(s1.equals(temp)){
                return true;
            }
        }

        return false;
    }
}
