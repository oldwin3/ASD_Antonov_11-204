public class Stack {
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
    }

    public void push(int element) {
        if (top == stackArray.length - 1) {
            System.out.println("Стек переполнен. Невозможно добавить элемент.");
        } else {
            stackArray[++top] = element;
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Стек пуст. Невозможно извлечь элемент.");
            return -1;
        } else {
            return stackArray[top--];
        }
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Стек пуст. Нет элементов для просмотра.");
            return -1;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }
}
