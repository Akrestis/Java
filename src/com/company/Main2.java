package com.company;

public class Main2 {

    public static void main(String[] args) {

        //2*. Объединить 2 бинарных дерева

        TreeNode treeOne = new TreeNode(1);
        treeOne.left = new TreeNode(3);
        treeOne.right = new TreeNode(2);
        treeOne.left.left = new TreeNode(5);

        TreeNode treeTwo = new TreeNode(2);
        treeTwo.left = new TreeNode(1);
        treeTwo.right = new TreeNode(3);
        treeTwo.left.right = new TreeNode(4);
        treeTwo.right.right = new TreeNode(7);

        TreeNode treeThree = mergeTrees(treeOne, treeTwo);
        printTree(treeThree);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        printTree(node.left);
        System.out.print(node.val + " ");
        printTree(node.right);
    }
}
