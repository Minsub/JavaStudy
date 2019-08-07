package com.minsub.java.test.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
 Example:
 
 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    @Test
    public void case1() {
    
        System.out.println(10 % 10);
    
        addTwoNumbers(generate(new int[]{1}), generate(new int[]{9,9}));
    
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode next = null;
        boolean isAddiable = false;
        do {
            if (l1 == null && l2 == null && isAddiable) {
                next.next = new ListNode(1);
                break;
            }
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (isAddiable ? 1 : 0);
            if (result == null) {
                result = new ListNode(  sum % 10);
                next = result;
            } else {
                next.next = new ListNode(sum % 10);
                next = next.next;
            }
    
            if (sum > 9) {
                isAddiable = true;
            } else {
                isAddiable = false;
            }
    
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        } while (l1 != null || l2 != null || isAddiable);
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode generate(int[] arr) {
        ListNode result = null;
        ListNode next = null;
        for (int i=0; i < arr.length; i++) {
            if (result == null) {
                result = new ListNode(arr[i]);
                next = result;
            } else {
                next.next = new ListNode(arr[i]);
                next = next.next;
            }
        }
        return result;
    }
    
    public void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
