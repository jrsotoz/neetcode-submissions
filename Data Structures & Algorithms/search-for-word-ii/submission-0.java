class Solution {
    List<String> ans;
    char[][] board;
    String[] words;
    public List<String> findWords(char[][] board, String[] words) {
        this.ans = new ArrayList<>();
        this.board = board;
        this.words = words;
        Trie root = new Trie();

        for(int i = 0 ; i < words.length ; i++){
            root.insert(words[i], i);
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                dfs(root, i, j);
            }
        }

        return ans;
    }
    public void dfs(Trie root, int i, int j){
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            board[i][j] == '.' || root.child[board[i][j] - 'a'] == null){
                return;
        }
        
        char temp = board[i][j];
        board[i][j] = '.';
        Trie prev = root;
        root = root.child[temp - 'a'];

        if(root.index != -1){
            ans.add(words[root.index]);
            root.index = -1;
            root.pref--;
            if(root.pref == 0){
                root = null;
                prev.child[temp - 'a'] = null;
                board[i][j] = temp;
                return ;
            }
        }

        dfs(root, i + 1 , j);
        dfs(root, i - 1 , j);
        dfs(root, i , j + 1);
        dfs(root, i , j - 1);

        board[i][j] = temp;
    }
}
class Trie {
    Trie[] child ;
    int pref;
    int index ;
    public Trie(){
        this.child = new Trie[26];
        this.pref = 0;
        this.index = -1;
    }
    public void insert(String word, int i){
        Trie current = this;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.child[index] == null){
                current.child[index] = new Trie();
            }
            current = current.child[index];
            current.pref++;
        }
        current.index = i;
    }
}