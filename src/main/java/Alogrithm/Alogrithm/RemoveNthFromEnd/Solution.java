package Alogrithm.Alogrithm.RemoveNthFromEnd;

/**
 * @Author zhangjiaheng
 * @Description 删除链表的倒数第N节点
 **/
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder s = new StringBuilder();
            while (node != null) {
                s.append(node.val).append(" -> ");
                node = node.next;
            }
            s.append("nil");
            return s.toString();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preNode = head;
        ListNode iNode = head;
        ListNode jNode = head;
        while (n-- != 0) {
            jNode = jNode.next;
        }
        if(jNode == null){
            // 倒数第n个一定是第一个
            head = head.next;
        }else{
            boolean flag = false;
            while (jNode != null) {
                iNode = iNode.next;
                jNode = jNode.next;
                if (flag) {
                    preNode = preNode.next;
                }
                flag = true;
            }
            if (preNode == iNode) {
                return null;
            }
            preNode.next = iNode.next;
            iNode.next = null;
        }
        return head;

    }

    public ListNode create(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode p = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            p.next = node;
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2};
        final Solution test = new Solution();
        final ListNode head = test.create(a);
        System.out.println(head);
        final ListNode node = test.removeNthFromEnd(head, 2);
        System.out.println(node);

    }
}
