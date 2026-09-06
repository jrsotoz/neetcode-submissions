class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            String stemp = findArray(s);
            List<String> temp = map.getOrDefault(stemp, new ArrayList<>());
            temp.add(s);
            map.put(stemp, temp);
        }

        for(Map.Entry<String, List<String>> m : map.entrySet()){
            ans.add(m.getValue());
        }

        return ans;
    }
    public String findArray(String s){
        List<Character> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            arr.add(c);
        }
        Collections.sort(arr);
        for(Character c : arr){
            sb.append(c);
        }
        return sb.toString();
    }
}
