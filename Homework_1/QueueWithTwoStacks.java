public class QueueWithTwoStacks {
    private Stack stack1;
    private Stack stack2;

    public QueueWithTwoStacks(int n) {
        stack1 = new Stack(n);
        stack2 = new Stack(n);
    }

    public void enqueue(int element) {
        stack1.push(element);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Очередь пуста. Невозможно извлечь элемент.");
                return -1;
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Очередь пуста. Нет элементов для просмотра.");
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

    public int size() {
        return stack1.size() + stack2.size();
    }
}

