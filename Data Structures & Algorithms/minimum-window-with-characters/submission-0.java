class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0){
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int[] res = new int[]{-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        int have = 0;
        int need = countT.size();

        for(int r = 0 ; r < s.length() ; r++){
            char temp = s.charAt(r);


            if(countT.containsKey(temp)){
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                if(countT.get(temp).equals(window.get(temp))){
                    have++;
                }
            }

            while(have == need){
                if((r - l + 1) < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                
                char remove = s.charAt(l);

                if(countT.containsKey(remove)){
                     window.put(remove, window.get(remove) - 1);
                    if(window.get(remove) < countT.get(remove)){
                        have--;
                    }
                }
                l++;
            }


        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
