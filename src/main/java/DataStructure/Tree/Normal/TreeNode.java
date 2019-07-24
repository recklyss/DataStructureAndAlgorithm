package DataStructure.Tree.Normal;

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
}
