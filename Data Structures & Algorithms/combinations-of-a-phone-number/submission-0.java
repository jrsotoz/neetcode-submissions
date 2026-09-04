class Solution {
    Map<Integer, List<Character>> dict;
    char[] c;

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if(digits.length() == 0){
            return list;
        }

        this.dict = new HashMap<>();
        this.c = digits.toCharArray();

        fillMap();

        dfs(list, 0, new StringBuilder());

        return list;
    }
    public void dfs(List<String> list, int index, StringBuilder sb){
        if(sb.length() == c.length){
            list.add(sb.toString());
            return;
        }

        List<Character> l = dict.get(Character.getNumericValue(c[index]));

        for(int i = 0 ; i < l.size() ; i++){
            char temp = l.get(i);
            sb.append(temp);
            dfs(list, index + 1 , sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        
    }

    public void fillMap(){
        List<Character> l ;
        for(int i = 2 ; i < 10 ; i++){
            l = new ArrayList<>();
            if(i == 2){
                l.add('a');
                l.add('b');
                l.add('c');
            }else if(i == 3){
                l.add('d');
                l.add('e');
                l.add('f');                
            }else if(i == 4){
                l.add('g');
                l.add('h');
                l.add('i');                   
            }else if(i == 5){
                l.add('j');
                l.add('k');
                l.add('l');                   
            }else if(i == 6){
                l.add('m');
                l.add('n');
                l.add('o');                   
            }else if(i == 7){
                l.add('p');
                l.add('q');
                l.add('r');
                l.add('s');                   
            }else if(i == 8){
                l.add('t');
                l.add('u');
                l.add('v');                   
            }else if(i == 9){
                l.add('w');
                l.add('x');
                l.add('y');
                l.add('z');                   
            }
            dict.put(i, l);
        }
    }
}