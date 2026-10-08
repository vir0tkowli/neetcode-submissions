class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String open = "({[<";
        String close = ")}]>";
        for (int i = 0; i < s.length(); i++) {
            if(open.contains(String.valueOf(s.charAt(i)))) {
                stack.push(s.charAt(i));
            } else {
                if(!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else if(!stack.isEmpty() && stack.peek() == '{' && s.charAt(i) == '}') {
                    stack.pop();
                } else if(!stack.isEmpty() && stack.peek() == '[' && s.charAt(i) == ']') {
                    stack.pop();
                } else if(!stack.isEmpty() && stack.peek() == '<' && s.charAt(i) == '>') {
                    stack.pop();
                } else {
                    return false;
                }  
            }    
        }
        return stack.isEmpty();
    }
}
