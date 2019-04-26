package DataStructure.List;

/**
 * @Author zhangjiaheng
 * @Description
 **/
public class MyNode {
    int val;
    MyNode next;

    MyNode(int val) {
        this.val = val;
        this.next = null;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public MyNode getNext() {
        return this.next;
    }

    @Override
    public String toString() {
        return "[val:"+val+",next:"+next+"]";
    }
}
