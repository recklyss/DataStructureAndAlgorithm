package DataStructure.Tree.avl;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * 红黑树节点
 * @author zhang
 */
@Getter
@Setter
public class AvlTreeNode {
    private int level;
    private int val;
    private AvlTreeNode left;
    private AvlTreeNode right;

    public AvlTreeNode(int val) {
        this.val = val;
    }

    public AvlTreeNode(int level, int val, AvlTreeNode left, AvlTreeNode right) {
        this.level = level;
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
