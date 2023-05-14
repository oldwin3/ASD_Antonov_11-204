//package Homework_AuCD_1;
//
//import java.util.LinkedList;
//import java.util.Queue;
//
//
//public class Tree {
//    public static class Node {
//        int value;
//        Homework_AuCD_1.Node left;
//        Homework_AuCD_1.Node right;
//
//        public Node(int value) {
//            this.value = value;
//            left = null;
//            right = null;
//        }
//    }
//    Node root;
//
//    public Tree() {
//        root = null;
//    }
//
//    public void breadthFirstTraversal() {
//        if (root == null) {
//            return;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            System.out.print(node.value + " ");
//            if (node.left != null) {
//                queue.add(node.left);
//            }
//            if (node.right != null) {
//                queue.add(node.right);
//            }
//        }
//    }
//}
