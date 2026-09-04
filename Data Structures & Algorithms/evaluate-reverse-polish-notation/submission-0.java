class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String c : tokens){
            if(isNum(c)){
                stack.add(Integer.parseInt(c));
            }else{
                int two = stack.pop();
                int one = stack.pop();
                if(c.equals("+")){
                    stack.add(one + two);
                }else if(c.equals("-")){
                    stack.add(one - two);
                }else if(c.equals("*")){
                    stack.add(one * two);
                }else{
                    stack.add(two == 0 ? 0 : one / two);
                }
            }
        }

        return stack.peek();
    }
    public boolean isNum(String s){
        try{
            Integer.parseInt(s);
        }catch(NumberFormatException e) { 
            return false;
        }
        return true;
    }
}
