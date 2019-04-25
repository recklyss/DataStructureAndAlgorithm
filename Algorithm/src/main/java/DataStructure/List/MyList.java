package DataStructure.List;

/**
 * @Author zhangjiaheng
 * @Description 链表实现
 **/
public class MyList {
    /**
     * 链表节点
     */
    static class MyNode {
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

    /**
     * 头节点引用
     */
    private MyNode first = null;
    /**
     * 尾节点引用
     */
    private MyNode last = null;

    /**
     * 根据数组构造链表
     */
    MyList(int[] arr) throws Exception {
        MyNode currn = null;
        if(arr.length == 0){
            throw new Exception("new array cannot be empty");
        }
        for (int i = 0; i < arr.length; i++) {
            MyNode nodei = new MyNode(arr[i]);
            if (i == 0) {
                first = nodei;
                currn = first;
            } else {
                currn.next = nodei;
                currn = currn.next;
            }
            last = currn;
        }
    }

    /**
     * 向链表末尾添加元素
     */
    public MyNode add(MyNode node){
        if (node == null) {
            throw new NullPointerException("new node cannot be null");
        }
        last.next = node;
        last = node;
        return first;
    }

    /**
     * 向指定下标插入元素
     */
    public MyNode add(MyNode node, int index) throws Exception {
        if(index < 0){
            throw new Exception("Index out of bound exception");
        }
        if(index == 0){

        }
        MyNode i = first;
        while(i.next != null && index -- > 0){
            i = i.next;
        }
        if(index > 0){
            throw new Exception("Index out of bound exception");
        }
        node.next = i.next;
        i.next = node;
        return first;
    }

    /**
     * 删除链表节点
     */
    public void remove(int val) {
        MyNode i = first, j = first;
        while (i.val == val) {
            first = first.next;
            i.next = null;
            i = first;
            j = first;

        }
        i = i.next;
        while (i != null) {
            if (i.val == val) {
                j.next = i.next;
                i.next = null;
                i = j.next;
            }else{
                i = i.next;
                j = j.next;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int a[] = {3, 3, 3, 4, 3, 6, 7, 8, 9};
        MyList list = new MyList(a);
        MyNode node = new MyNode(7);
        list.add(node, 1);
        System.out.println(list);
        System.out.println(list.first);

    }

    @Override
    public String toString() {
        System.out.print("list : ");
        MyNode node = first;
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("nil");
        return "";
    }
}
