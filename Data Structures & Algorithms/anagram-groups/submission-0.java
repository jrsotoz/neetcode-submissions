class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String str = String.valueOf(c);
            List<String> list = map.getOrDefault(str, new ArrayList<>());
            list.add(s);
            map.put(str, list);
        }

        for(Map.Entry<String, List<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }


        return ans;
    }
}
