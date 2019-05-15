package Alogrithm.Alogrithm.AddWithList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

/**
 * 俩个数相加 使用链表 存储方式为逆序存储
 */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        ListNode pre = node;
        int tmpInt = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + node.val;
            if (sum >= 10) {
                tmpInt = 1;
                sum = sum - 10;
            } else {
                tmpInt = 0;
            }
            node.val = sum;
            node.next = new ListNode(tmpInt);
            pre = node;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (null != l1) {
            int sum = l1.val + tmpInt;
            if (sum >= 10) {
                tmpInt = 1;
                sum = sum - 10;
            } else {
                tmpInt = 0;
            }
            node.val = sum;
            node.next = new ListNode(tmpInt);
            l1 = l1.next;
            pre = node;
            node = node.next;
        }
        while (null != l2) {
            int sum = l2.val + tmpInt;
            if (sum >= 10) {
                tmpInt = 1;
                sum = sum - 10;
            } else {
                tmpInt = 0;
            }
            node.val = sum;
            node.next = new ListNode(tmpInt);
            l2 = l2.next;
            pre = node;
            node = node.next;
        }
        if (null != pre.next && 0 == pre.next.val) {
            pre.next = null;
        }
        return result;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();
        ListNode list1 = new ListNode(9);
        list1.next = new ListNode(9);
        ListNode list2 = new ListNode(5);
        ListNode list = obj.addTwoNumbers(list1, list2);
        while (list != null) {
            System.out.print(list.val);
            list = list.next;
        }
    }
}
