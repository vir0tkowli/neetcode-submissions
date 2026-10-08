class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> res = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            String cur = operations[i];
            if (cur.equals("+")) {
                //assuming res always has 2 numbers before it
                int first = res.pop();
                int second = res.pop();
                res.push(second);
                res.push(first);
                res.push(first + second);
            } else if(cur.equals("C")) {
                res.pop();
            } else if (cur.equals("D")) {
                res.push(res.peek() * 2);
            } else {
                res.push(Integer.parseInt(cur));
            }
        }
        int result = 0;
        while (!res.isEmpty()) {
            result += res.pop();
        }
        return result;
    }
}