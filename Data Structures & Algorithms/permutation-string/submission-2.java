class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()){
            return false;
        }

        int[] arrayS1 = new int[26];
        int[] arrayS2 = new int[26];

        for(int i = 0 ; i < s1.length() ; i++){
            arrayS1[s1.charAt(i) - 'a']++;
            arrayS2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0 ; i < s2.length() - s1.length() ; i++){
            if(check(arrayS1, arrayS2)){
                return true;
            }

            arrayS2[s2.charAt(i) - 'a']--;
            arrayS2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return check(arrayS1, arrayS2);
    }

    public boolean check(int[] s1, int[] s2){
        for(int i = 0 ; i < 26 ; i++){
            if(s1[i] != s2[i]){
                return false;
            }
        }
        return true;
    }
}
