package merge_k_sorted_lists;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0) { return null; }
		if (lists.length == 1) { return lists[0]; }
        return mergeKLists(lists, 0, lists.length - 1);
    }
	
	private ListNode mergeKLists(ListNode[] lists, int s, int e) {
		if (e - s > 1) {
			int m = (e + s) / 2;
			return merge(mergeKLists(lists, s, m), mergeKLists(lists, m + 1, e));
		}
		return merge(lists[s], lists[e]);
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		
		if (l1 == l2) { return l1; }
		ListNode root = new ListNode(), ptr = root, cur1 = l1, cur2 = l2;
			
		while (cur1 != null && cur2 != null) {
			if (cur1.val <= cur2.val) {
				ptr.next = cur1; ptr = cur1; cur1 = cur1.next;
			} else {
				ptr.next = cur2; ptr = cur2; cur2 = cur2.next;
			}
		}
		ptr.next = cur2 == null ? cur1 : cur2;
		return root.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { 
		this.val = val; this.next = next; 
	}
}
