package DataStructure.Tree;

import java.util.LinkedList;
import java.util.Stack;

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
     * 创建完全二叉树
     * 完全二叉树 ： 从上往下左右子女都存在 并且连续缺失叶节点 即最后一行 右边缺失 左边连续
     * 即按行创建二叉树即可 使用队列完成
     */
    public static TreeNode createWholeTree(int[] a) {
        if (a.length > 0) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(a[0]);
            queue.add(root);
            int index = 0;
            for (int i = 1; i < a.length; i++) {
                TreeNode curn = queue.get(index);
                TreeNode ti = new TreeNode(a[i]);
                queue.add(ti);
                if (curn.left == null) {
                    curn.left = ti;
                } else if (curn.right == null) {
                    curn.right = ti;
                    index++;
                }
            }
            return root;
        }
        return null;
    }

    /**
     * 递归先序遍历二叉树 左-根-右
     */
    public static void frontPrintOutTree(TreeNode root) {
        if (null != root) {
            System.out.print(root.val + " | ");
            frontPrintOutTree(root.left);
            frontPrintOutTree(root.right);
        }
    }

    /**
     * 二叉树非递归先序遍历
     * 思路：先将根节点入栈，然后循环执行以下操作
     * 出栈，若出栈节点不为空，就将节点的左右子女入栈，循环执行
     */
    public static void frontPrintByLoop(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.print(node.val + " | ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 递归中序遍历二叉树 左-根-右
     * 二叉搜索树的中序遍历输出的为有序序列
     */
    public static void midPrintOutTree(TreeNode root) {
        if (null != root) {
            midPrintOutTree(root.left);
            System.out.print(root.val + " | ");
            midPrintOutTree(root.right);
        }
    }

    /**
     * 非递归中序遍历
     * 二叉搜索树的中序遍历输出的为有序序列
     * 思路：使用栈，先将树的左子女入栈
     * 然后在出栈时，每出栈一个元素
     * 判断其是否有右子树，有的话入栈
     */
    public static void midPrintByLoop(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            stack.push(node);
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (null != node) {
                    TreeNode n = node.right;
                    while (n != null) {
                        stack.push(n);
                        n = n.left;
                    }
                    System.out.print(node.val + " | ");
                }
            }

        }
    }

    /**
     * 递归后序遍历二叉树 左-右-根
     */
    public static void lastPrintOutTree(TreeNode root) {
        if (null != root) {
            lastPrintOutTree(root.left);
            lastPrintOutTree(root.right);
            System.out.print(root.val + " | ");
        }
    }

    /**
     * 非递归后序遍历
     * 这里采用了逆转先序遍历的方式完成
     * 先序遍历是 左右根
     * 后序遍历是 根左右
     * 这样写的好处是代码简单好理解 缺点是多用了一个栈 时间和空间复杂度增加
     */
    public static void lastPrintByOtherStack(TreeNode root) {
        if (root != null) {
            final Stack<TreeNode> stack = new Stack<>();
            final Stack<TreeNode> stackReverse = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    stackReverse.push(node);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            }
            while (!stackReverse.isEmpty()) {
                TreeNode node = stackReverse.pop();
                System.out.print(node.val + " | ");
            }
        }
    }

    /**
     * 非递归后序遍历二叉树 只使用一个栈
     */
    public static void lastPrintByOneStack(TreeNode root) {
        if (null != root) {
            TreeNode h = root;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(h);
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                if (node.left != null && node.left != h && node.right != h) {
                    stack.push(node.left);
                } else if (null != node.right && node.right != h) {
                    stack.push(node.right);
                } else {
                    node = stack.pop();
                    System.out.print(node.val + " | ");
                    h = node;
                }
            }
        }
    }

    /**
     * 按层遍历二叉树
     */
    public static void levelPrintOutTree(TreeNode root) {
        if (null != root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode i = root;
            while (!queue.isEmpty()) {
                if (i.left != null) {
                    queue.add(i.left);
                }
                if (i.right != null) {
                    queue.add(i.right);
                }
                System.out.print(i.val + " | ");
                queue.poll();
                i = queue.peek();
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 6, 1, 4, 2, 5, 9, 8, 0, 7};
        TreeNode root = createSearchTree(a);
        System.out.println("\n----------------先序递归");
        frontPrintOutTree(root);
        System.out.println("\n----------------先序非递归");
        frontPrintByLoop(root);
        System.out.println("\n----------------中序递归");
        midPrintOutTree(root);
        System.out.println("\n----------------中序非递归");
        midPrintByLoop(root);
        System.out.println("\n----------------后序递归");
        lastPrintOutTree(root);
        System.out.println("\n----------------后序非递归两个栈");
        lastPrintByOtherStack(root);
        System.out.println("\n----------------后序非递归一个栈");
        lastPrintByOneStack(root);
        System.out.println("\n----------------按层遍历");
        levelPrintOutTree(root);
    }
}
