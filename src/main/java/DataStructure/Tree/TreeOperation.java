package DataStructure.Tree;

import java.util.LinkedList;

/**
 * @Author zhangjiaheng
 * @Description 一些创建二叉树、遍历等方法
 **/
public class TreeOperation {

    /**
     * 创建二叉查找树
     */
    public static TreeNode createSearchTree(int[] a) {
        if (a.length > 0) {
            TreeNode root = new TreeNode(a[0]);
            for (int i = 1; i < a.length; i++) {
                TreeNode c = root;
                TreeNode p = c;
                TreeNode q = new TreeNode(a[i]);
                while (c != null) {
                    p = c;
                    if (a[i] <= c.val) {
                        c = c.left;
                    } else {
                        c = c.right;
                    }
                }
                if (q.val < p.val) {
                    p.left = q;
                } else {
                    p.right = q;
                }
            }
            return root;
        }
        return null;
    }

    /**
     * 递归先序遍历二叉树 左-根-右
     */
    public static void frontPrintOutTree(TreeNode root){
        if(null != root){
            System.out.print(root.val);
            frontPrintOutTree(root.left);
            frontPrintOutTree(root.right);
        }
    }

    /**
     * 递归中序遍历二叉树 左-根-右
     */
    public static void midPrintOutTree(TreeNode root){
        if(null != root){
            midPrintOutTree(root.left);
            System.out.print(root.val);
            midPrintOutTree(root.right);
        }
    }

    /**
     * 递归先序遍历二叉树 左-根-右
     */
    public static void lastPrintOutTree(TreeNode root){
        if(null != root){
            lastPrintOutTree(root.left);
            lastPrintOutTree(root.right);
            System.out.print(root.val);
        }
    }

    /**
     * 按层遍历二叉树
     */
    public static void levelPrintOutTree(TreeNode root){
        if(null != root){
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode i = root;
            while(!queue.isEmpty()){
                if(i.left != null){
                    queue.add(i.left);
                }
                if(i.right != null){
                    queue.add(i.right);
                }
                System.out.print(i.val);
                queue.poll();
                i = queue.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        TreeNode root = createSearchTree(a);
        System.out.println(root);
        frontPrintOutTree(root);
        System.out.println();
        midPrintOutTree(root);
        System.out.println();
        lastPrintOutTree(root);
        System.out.println();
        levelPrintOutTree(root);
    }
}
