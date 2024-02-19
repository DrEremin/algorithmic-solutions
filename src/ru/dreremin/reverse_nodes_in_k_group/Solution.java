package ru.dreremin.reverse_nodes_in_k_group;

public class Solution {
	public static ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(head, k, null);
    }
	
	public static ListNode reverseKGroup(ListNode head, int k, ListNode prev) {
		if (k == 1 || head == null) { return head; }
        
        ListNode h = head, c = head, n;
		
        if (isThereRequiredNodesAmount(h, k)) {
        	for (int i = 0; i < k - 1; i++) {
        		n = c.next;
        		c.next = n.next;
        		n.next = h;
        		h = n;
        	}
        	if (prev != null) { prev.next = h; }
        	reverseKGroup(c.next, k, c);
        }
        return h;
	}
	
	
	
	private static boolean isThereRequiredNodesAmount(ListNode n, int k) {
		
		boolean f = true;
		
		for (int i = 0; i < k; i++) {
			if (n == null) {
				f = false;
				break;
			}
			n = n.next;
		}
		return f;
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { 
			this.val = val; this.next = next; 
		}
	}
}
