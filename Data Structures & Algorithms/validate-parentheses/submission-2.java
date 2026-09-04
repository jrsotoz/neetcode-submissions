class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(Character c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.add(c);
            }else{
                if(stack.isEmpty()) return false;
                char temp = stack.peek();
                if((c == ')' && temp == '(') || (c == ']' && temp == '[') || (c == '}' && temp == '{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
