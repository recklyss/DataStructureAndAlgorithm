package DataStructure.Tree;

/**
 * @Author zhangjiaheng
 * @Description 二叉树节点元素
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "(" + val + ")[left:" + left + ",right:" + right + "]";
    }

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        System.out.println(t1);
    }
}
