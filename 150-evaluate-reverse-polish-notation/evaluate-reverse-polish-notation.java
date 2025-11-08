class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> solve = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = solve.pop();
                int a = solve.pop();
                solve.push(a + b);
            } else if (token.equals("-")) {
                int b = solve.pop();
                int a = solve.pop();
                solve.push(a - b);
            } else if (token.equals("*")) {
                int b = solve.pop();
                int a = solve.pop();
                solve.push(a * b);
            } else if (token.equals("/")) {
                int b = solve.pop();
                int a = solve.pop();
                solve.push(a / b);
            } else {
                solve.push(Integer.parseInt(token));
            }
        }

        return solve.pop();
    }
}
