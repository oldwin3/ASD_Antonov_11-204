package Homework_AuCD_1;

import java.util.*;

class Node {
    Node parent;

    Node() {
        parent = this;
    }

    Node findRoot() {
        Node root = this;
        while (root.parent != root) {
            root = root.parent;
        }
        Node current = this;
        while (current.parent != root) {
            current = current.parent;
            current.parent = root;
        }
        return root;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        while (scanner.hasNext()) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            Node rootA = nodes[a].findRoot();
            Node rootB = nodes[b].findRoot();
            if (rootA != rootB) {
                rootA.parent = rootB;
                System.out.printf("(%d,%d)\n", a + 1, b + 1);
            }
            else {
                System.out.printf("null (%d,%d)\n", a + 1, b + 1);
            }
        }
    }
}

