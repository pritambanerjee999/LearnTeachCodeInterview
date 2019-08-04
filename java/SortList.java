package com.leetcode.bst;

public class SortList {
    
    public ListNode sortList(ListNode head) {
        if(head == null) {return null;}
        
        if(head.next == null) { return head;}
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null) {
          prev = slow;
          slow = slow.next;
          fast = fast.next.next;
        }
        
        prev.next = null;
      
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        ListNode result = merge(l1, l2);
        
        return result;
        
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null ) { return l2; }
        if(l2 == null ) { return l1; }
        
        ListNode l = new ListNode(0);
        ListNode newHead = l;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l.next = l1;
                l1 = l1.next;  
            }
            else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        
        if(l1 != null) {
            l.next = l1;
            l1 = l1.next;
        }
       
        if(l2 != null) {
            l.next = l2;
            l2 = l2.next;
        }
        
        return newHead.next;
    }

}
