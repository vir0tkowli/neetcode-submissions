class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for(Character c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else if(c == ')' && !stack.isEmpty()) {
                maxDepth = Math.max(maxDepth, stack.size());
                stack.pop();
            }
        }
        return maxDepth;
    }
}