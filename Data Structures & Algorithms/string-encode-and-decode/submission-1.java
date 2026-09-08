class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        List<Integer> sizes = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sizes.addLast(s.length());
        }
        for(Integer i : sizes){
            sb.append(i);
            sb.append(',');
        }
        sb.append('#');
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.isEmpty()) return new ArrayList<>();

        List<String> ans = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i = 0 ;

        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            while(str.charAt(i) != ','){
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;

        for(int sz : sizes){
            ans.add(str.substring(i, i + sz));
            i += sz;
        }

        return ans;


    }
}
