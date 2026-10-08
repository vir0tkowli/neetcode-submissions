class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> monotonicallyIncStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while(!monotonicallyIncStack.isEmpty() && temperatures[monotonicallyIncStack.peek()] < temperatures[i]) {
                int prevIdx = monotonicallyIncStack.pop();
                res[prevIdx] = i - prevIdx;
            }
            monotonicallyIncStack.push(i);
        }
        return res;
    }
}
