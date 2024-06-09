package com.hzx.leetcode.util.tree;

/**
 * 手写二叉树
 */
public class MyBinaryTree {
    TreeNode root;

    MyBinaryTree() {
        root = null;
    }

    MyBinaryTree(int data) {
        root = new TreeNode(data);
    }

    //返回根节点
    public TreeNode getRoot() {
        return root;
    }

    // 插入新节点  
    void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        } else if (data <= root.data) {
            root.left = insertRec(root.left, data);
        } else {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    // 删除节点
    void delete(int data) {
        root = deleteRecursive(root, data);
    }

    private int findMindataue(TreeNode root) {
        int mindata = root.data;
        while (root.left != null) {
            mindata = root.left.data;
            root = root.left;
        }
        return mindata;
    }


    private TreeNode deleteRecursive(TreeNode root, int data) {
        if (root == null) {
            return null;
        }

        if (data == root.data) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMindataue(root.right);
            root.right = deleteRecursive(root.right, root.data);
        } else if (data < root.data) {
            root.left = deleteRecursive(root.left, data);
        } else {
            root.right = deleteRecursive(root.right, data);
        }

        return root;
    }

    // 查找节点
    public boolean contains(int data) {
        return containsRecursive(root, data);
    }

    private boolean containsRecursive(TreeNode root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return containsRecursive(root.left, data);
        } else {
            return containsRecursive(root.right, data);
        }
    }


    // 前序遍历  （根-左-右）
    void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 中序遍历  （左-根-右）
    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    // 后序遍历  （左-右-根）
    void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.preOrder(tree.root); // 输出: 5 3 2 4 7 6 8
        System.out.println();
        tree.inOrder(tree.root); // 输出: 2 3 4 5 6 7 8
        System.out.println();
        tree.postOrder(tree.root); // 输出: 2 4 3 6 8 7 5
        System.out.println();



        TreeNode treeNode = tree.invertTree(tree.root);
        tree.inOrder(treeNode); // 输出翻转后的二叉树: 8 7 6 5 4 3 2
        System.out.println();


    }
}
