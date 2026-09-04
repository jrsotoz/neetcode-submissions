class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0){
            return 0;
        }
        Map<String, List<String>> map = new HashMap<>();

        wordList.add(beginWord);

        for(String s : wordList){
            for(int i = 0 ; i < s.length() ; i++){
                String ns = s.substring(0 , i) + '*' + s.substring(i + 1, s.length());
                List<String> l = map.getOrDefault(ns, new ArrayList<>());
                l.add(s);
                map.put(ns, l);
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int levels = 0;

        while(!q.isEmpty()){
            int size = q.size();
            levels++;

            for(int i = 0 ; i < size ; i++){
                String s = q.remove();

                if(s.equals(endWord)){
                    return levels;
                }

                for(int j = 0 ; j < s.length() ; j++){
                    String sub = s.substring(0, j) + '*' + s.substring(j + 1, s.length());
                    for(String list : map.get(sub)){
                        if(!visited.contains(list)){
                            q.add(list);
                            visited.add(list);
                        }
                    }

                }
            }
        }
        
        return 0;
    }
}
