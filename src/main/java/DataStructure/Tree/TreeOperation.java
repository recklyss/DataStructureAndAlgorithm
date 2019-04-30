package DataStructure.Tree;

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

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 8, 4, 7, 6, 9, 1};
        TreeNode root = createSearchTree(a);
        System.out.println(root);
    }
}
