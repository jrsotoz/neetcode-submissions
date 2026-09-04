class WordDictionary {
    Trie root;

    public WordDictionary() {
        this.root = new Trie();
    }

    public void addWord(String word) {
        Trie current = root;
        for(int c : word.toCharArray()){
            if(current.children[c - 'a'] == null){
                current.children[c - 'a'] = new Trie();
            }
            current = current.children[c - 'a'];
        }
        current.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int j, Trie root){
        Trie current = root;

        for(int i = j ; i < word.length() ; i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(Trie child : current.children){
                    if(child != null && dfs(word, i + 1 , child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(current.children[c - 'a'] == null){
                    return false;
                }else{
                    current = current.children[c - 'a'];
                }
            }
        }

        return current.end;
    }
}
class Trie {
    Trie[] children;
    boolean end;

    public Trie(){
        this.children = new Trie[26];
        this.end = false;
    }
}