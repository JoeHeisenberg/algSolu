package learn.alg.stack;

import java.util.Stack;

/**
 * 最小栈
 *
 * @author: heisenberg 2021-06-04
 **/
public class Stack155 {
    private Stack<Integer> minstack = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public void push(Integer e) {
        stack.push(e);
        if (minstack.empty() || e <= minstack.peek()) {
            minstack.push(e);
        }
    }

    public Integer pop() {
        if (stack.empty()) {
            return null;
        }
        if (minstack.peek().equals(stack.peek())) {
            minstack.pop();
        }
        return stack.pop();
    }

    public Integer getMin() {
        return minstack.peek();
    }
}
