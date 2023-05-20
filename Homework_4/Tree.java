import lombok.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.io.IOException;
import java.io.RandomAccessFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tree {
    private int value;
    private Tree left;
    private Tree right;
    private Tree parent;

    public static int sumDeep(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            System.out.println(node.value);
            summ = summ + node.value;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return summ;
    }

    public static int sumWide(Tree root) {
        Queue<Tree> stack = new ArrayDeque<>();
        stack.add(root);
        int summ = 0;
        while (!stack.isEmpty()) {
            Tree node = stack.remove();
            System.out.println(node.value);
            summ = summ + node.value;
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return summ;
    }

    public Tree get(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.get(value);
        } else if (value > this.value && this.right != null) {
            return this.right.get(value);
        } else {
            return null;
            //throw new NoSuchElementException();
        }
    }

    public Tree add(int value) {
        Tree newNode = new Tree(value, null, null, this);
        if (value < this.value) {
            if (this.left == null) {
                this.left = newNode;
            } else {
                this.left.add(value);
            }
        } else if (value > this.value) {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right.add(value);
            }
        }
        return newNode;
    }

    public void remove(int value) {
        Tree nodeToRemove = get(value);
        if (nodeToRemove == null) {
            return;
        }
        if (nodeToRemove == this) {
            if (left == null && right == null) {
                value = 0;
            } else if (left == null) {
                value = right.value;
                left = right.left;
                right = right.right;
            } else if (right == null) {
                value = left.value;
                right = left.right;
                left = left.left;
            } else {
                Tree minNode = right.findMin();
                value = minNode.value;
                minNode.remove(minNode.value);
            }
        } else {
            if (nodeToRemove.left == null && nodeToRemove.right == null) {
                if (nodeToRemove.parent.left == nodeToRemove) {
                    nodeToRemove.parent.left = null;
                } else {
                    nodeToRemove.parent.right = null;
                }
            } else if (nodeToRemove.left == null) {
                if (nodeToRemove.parent.left == nodeToRemove) {
                    nodeToRemove.parent.left = nodeToRemove.right;
                } else {
                    nodeToRemove.parent.right = nodeToRemove.right;
                }
                nodeToRemove.right.parent = nodeToRemove.parent;
            } else if (nodeToRemove.right == null) {
                if (nodeToRemove.parent.left == nodeToRemove) {
                    nodeToRemove.parent.left = nodeToRemove.left;
                } else {
                    nodeToRemove.parent.right = nodeToRemove.left;
                }
                nodeToRemove.left.parent = nodeToRemove.parent;
            } else {
                Tree minNode = nodeToRemove.right.findMin();
                nodeToRemove.value = minNode.value;
                minNode.remove(minNode.value);
            }
        }
    }

    private Tree findMin() {
        Tree node = this;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printToFile(RandomAccessFile file) throws IOException {
        if (this == null) {
            return;
        }

        // Переводим значение узла в строку и записываем его в файл
        String valueString = Integer.toString(value);
        file.write(valueString.getBytes());
        file.write(" ".getBytes());

        if (left != null) {
            String leftString = Integer.toString(left.value);
            file.write(leftString.getBytes());
            file.write("(".getBytes());
            file.write(valueString.getBytes());
            file.write(")".getBytes());
            file.write(" ".getBytes());
            left.printToFile(file);
        }


        if (right != null) {
            String rightString = Integer.toString(right.value);
            file.write(rightString.getBytes());
            file.write("(".getBytes());
            file.write(valueString.getBytes());
            file.write(")".getBytes());
            file.write(" ".getBytes());
            right.printToFile(file);
        }
    }
}