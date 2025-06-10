class Solution {
    public int calculate(String s) {
        int n = s.length();
        int sum = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // because for loop also increments i
                sum += num * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum = st.pop() * sum; // sign
                sum += st.pop();      // previous sum
            }
        }

        return sum;
    }
}
