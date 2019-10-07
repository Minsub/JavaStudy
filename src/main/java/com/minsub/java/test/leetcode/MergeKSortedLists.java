package com.minsub.java.test.leetcode;

import org.junit.Test;

/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 
 Example:
 
 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    static public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null, tmp = null;
        while(true) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i=0; i<lists.length; i++) {
                if (lists[i] == null) continue;
                if (lists[i].val < min) {
                    min = lists[i].val;
                    idx = i;
                }
            }
            if (idx == -1) {
                break;
            }
            if (result == null) {
                result = new ListNode(min);
                tmp = result;
            } else {
                tmp.next = new ListNode(min);
                tmp = tmp.next;
            }
            lists[idx] = lists[idx].next;
        }
        
        return result;
    }
    
    public ListNode[] convert(int[][] data) {
        ListNode[] result = new ListNode[data.length];
        for (int i=0; i<data.length; i++) {
            result[i] = new ListNode(data[i][0]);
            ListNode tmp = result[i];
            for(int j=1; j<data[i].length; j++) {
                tmp.next = new ListNode(data[i][j]);
                tmp = tmp.next;
            }
        }
        return result;
    }
    
    public void print(ListNode data) {
        if (data == null) System.out.println("data is null");
        ListNode tmp = data;
        while(tmp != null) {
            System.out.print(tmp.val + " -> ");
            tmp = tmp.next;
        }
    }
    
    @Test
    public void case1() {
        int[][] case1 = {{1,4,5},{1,3,4},{2,6}};
        ListNode[] nodes = convert(case1);
        for (int i=0; i < nodes.length; i++) {
            print(nodes[i]);
            System.out.println();
        }
        print(mergeKLists(nodes));
    }
}
