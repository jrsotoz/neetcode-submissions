class Solution {
    List<String> ans;
    int n;

    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<>();
        this.n = n;

        backtrack(0,0,new StringBuilder());

        return ans;        
    }

    public void backtrack(int open, int close, StringBuilder s){
        if(s.length() >= n * 2){
            ans.add(s.toString());
            return;
        }

        StringBuilder aux = new StringBuilder(s);

        if(open < n){
            backtrack(open + 1, close, aux.append('('));
            aux.deleteCharAt(aux.length() - 1);
        }
        
        if(close < open){
            backtrack(open, close + 1, aux.append(')'));
            aux.deleteCharAt(aux.length() - 1);
        }

    }
}
