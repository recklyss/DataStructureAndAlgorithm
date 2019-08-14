package Alogrithm.Alogrithm.mergeKSortedLists;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Fork/join合并K个有序链表
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        MergeKListsTask task = new MergeKListsTask(lists);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<ListNode> result = pool.submit(task);
        ListNode listNode = null;
        try {
            listNode = result.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return listNode;
    }

    static class MergeKListsTask extends RecursiveTask<ListNode> {
        private ListNode[] lists;

        public MergeKListsTask(ListNode[] lists) {
            this.lists = lists;
        }

        @Override
        protected ListNode compute() {
            if (lists.length >= 2) {
                int mid = lists.length / 2;
                ListNode[] l1 = new ListNode[mid];
                ListNode[] l2 = new ListNode[lists.length - mid];
                System.arraycopy(lists, 0, l1, 0, mid);
                System.arraycopy(lists, mid, l2, 0, lists.length - mid);
                MergeKListsTask taskChild1 = new MergeKListsTask(l1);
                MergeKListsTask taskChild2 = new MergeKListsTask(l2);
                invokeAll(taskChild1, taskChild2);
                ListNode node1 = taskChild1.join();
                ListNode node2 = taskChild2.join();
                ListNode newNode = new ListNode(-1),point = newNode;
                while (node1 != null && node2 != null) {
                    if (node1.val < node2.val) {
                        point.next = node1;
                        node1 = node1.next;
                    } else {
                        point.next = node2;
                        node2 = node2.next;
                    }
                    point = point.next;
                }
                while (node1 != null) {
                    point.next = node1;
                    point = point.next;
                    node1 = node1.next;
                }
                while (node2 != null) {
                    point.next = node2;
                    point = point.next;
                    node2 = node2.next;
                }
                return newNode.next;
            }
            return lists[0];
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "[val=" + val + "]->" + next;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        ListNode b1 = new ListNode(8);
        ListNode b2 = new ListNode(9);
        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(11);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        c1.next = c2;
        c2.next = c3;
        ListNode[] listNodes = {a1, b1, c1};
        ListNode newNode = new Solution().mergeKLists(listNodes);
        System.out.println(newNode);
    }
}


