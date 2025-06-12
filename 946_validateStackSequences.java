class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        int popIndex = 0;
        // while(pushIndex<pushed.length)
        // {
        //     if(pushed[pushIndex]!=popped[popIndex])
        //     {
        //         stack.push(pushed[pushIndex]);
        //         pushIndex++;
        //     }
        //     else
        //     {
        //         pushIndex++;
        //         popIndex++;
        //         while(!stack.isEmpty() && stack.peek()==popped[popIndex])
        //         {
        //             stack.pop();
        //             popIndex++;
        //         }
        //     }

        // }

        //Another shorter way to write the same logic
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
