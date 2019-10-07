package com.minsub.java.test.leetcode;

import org.junit.Test;

/**
 Given a linked list, remove the n-th node from the end of list and return its head.
 
 Example:
 
 Given linked list: 1->2->3->4->5, and n = 2.
 
 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 
 Given n will always be valid.
 
 Follow up:
 
 Could you do this in one pass?
 */
public class RemoveNode {
    
    @Test
    public void case1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(removeNthFromEnd(head, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) return null;
        int length = 1;
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            length++;
        }
        if (length == n) return head.next;
        tmpNode = head;
        int target = length - n - 1;
        target = target < 0 ? 0 : target;
        for (int i=0; i < length; i++) {
            if (i == target) {
                tmpNode.next = tmpNode.next == null ? null : tmpNode.next.next;
                break;
            }
            tmpNode = tmpNode.next;
        }
        
        return head;
    }
    
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
