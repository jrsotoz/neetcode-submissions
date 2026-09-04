class Solution {
    char[] c;
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        List<List<String>> list = new ArrayList<>();
        this.c = s.toCharArray();

        dfs(list, 0, new ArrayList<>());

        return list;
    }
    public void dfs(List<List<String>> list, int index, List<String> l){
        if(index == c.length){
            list.add(new ArrayList<>(l));
            return;
        }
        for(int i = index ; i < c.length ; i++){
            if(isPalindrome(index, i, s.substring(index, i + 1))){
                l.add(s.substring(index, i + 1));
                dfs(list, i + 1, l);
                l.remove(l.size() - 1);
            }
        }
    }
    public boolean isPalindrome(int start, int end, String sub){
        StringBuilder sb = new StringBuilder(sub);
        return sub.equals(sb.reverse().toString());
    }
}