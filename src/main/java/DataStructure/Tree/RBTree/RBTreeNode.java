package DataStructure.Tree.RBTree;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author zhangjiaheng
 * @Description 红黑树节点
 **/
@Getter
@Setter
@ToString
public class RBTreeNode<T> {
    private T data;
    private boolean red;
    private RBTreeNode<T> left;
    private RBTreeNode<T> right;

    public RBTreeNode(T data, boolean red) {
        this.data = data;
        this.red = red;
    }

    public RBTreeNode(T data) {
        this.data = data;
    }
}
