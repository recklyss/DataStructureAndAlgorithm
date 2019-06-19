package Alogrithm.Alogrithm.SwapPairs;

public class Solution {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /** 两两交换链表中的节点 */
  public ListNode swapPairs(ListNode head) {
    if (head != null && head.next != null) {
      head = swapTwoNodes(head, head.next);
    }
    return head;
  }

  public ListNode swapTwoNodes(ListNode first, ListNode next) {
    // 如果两个节点中有一个是null
    // 说明之前调用的时候已经到最后一个
    // 或者最后一个已经交换完成
    // 这时直接返回就行了
    if (first != null && next != null) {
      ListNode n = first;
      ListNode p = next;
      first = p;
      n.next = p.next;
      p.next = n;
      n.next = swapTwoNodes(n.next, n.next.next);
    }
    return first;
  }
}
