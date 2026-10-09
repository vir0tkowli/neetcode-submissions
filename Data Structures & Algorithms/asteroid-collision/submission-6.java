class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> ast = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int a = asteroids[i];

            if (ast.isEmpty() || ast.peek() < 0 || a > 0) {
                ast.push(a);
            } else if (!ast.isEmpty() && (ast.peek() + a < 0)) {
                ast.pop();
                i--;
            } else if (!ast.isEmpty() && (ast.peek() + a == 0)) {
                ast.pop();
            }
        }
        System.out.printf("** STACK: %s\n", ast);

        int[] res = new int[ast.size()];
        int i = res.length - 1;
        while(!ast.isEmpty()) {
            res[i] = ast.pop();
            i--;
        }
        return res;
    }
}