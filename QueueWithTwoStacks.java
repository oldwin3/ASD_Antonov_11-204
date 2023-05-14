package Homework_AuCD_1;

import java.util.Stack;

public class QueueWithTwoStacks<T> {

    private Stack<T> pushStack = new Stack<>();
    private Stack<T> popStack = new Stack<>();

    public void enqueue(T item) {
        pushStack.push(item);
    }

    public T dequeue() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public boolean isEmpty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    public int size() {
        return pushStack.size() + popStack.size();
    }
}
