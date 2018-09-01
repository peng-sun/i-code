package icode.binary_tree;

import icode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(TreeNode root) {this.root = root;}

    // deserialize
    public BinaryTree(String data) {

        if (data.equals("{}")) {root = null; return;}

        String[] vals = data.substring(1, data.length() - 1).split(",");

        Queue<String> queue = new LinkedList<>(Arrays.asList(vals));

        root = dHelper(queue);
    }

    private TreeNode dHelper(Queue<String> queue) {
        String top = queue.poll();

        if (top.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(top));
        node.left = dHelper(queue);
        node.right = dHelper(queue);

        return node;
    }

    public String serialize() {
        if (root == null) return "{}";

        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append(String.valueOf(root.val));
        sHelper(root.left, sb);
        sHelper(root.right, sb);
        sb.append("}");

        return sb.toString();
    }
    private void sHelper(TreeNode root, StringBuilder sb) {

        if (root == null) sb.append(",#");
        else {
            sb.append(",");
            sb.append(String.valueOf(root.val));
            sHelper(root.left, sb);
            sHelper(root.right, sb);
        }
    }

    public boolean compare(BinaryTree second) {
        return compareTrees(this.root, second.root);
    }

    private boolean compareTrees(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;

        if (a == null || b == null) return false;

        if (a.val != b.val) {
            return false;
        }

        return compareTrees(a.left, b.left) && compareTrees(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        root.left = node1;
        root.right = node3;

        BinaryTree tree1 = new BinaryTree(root);

        String data = tree1.serialize();

        System.out.println(data);

        BinaryTree tree2 = new BinaryTree(data);

        System.out.println(tree1.compare(tree2));
    }
}
