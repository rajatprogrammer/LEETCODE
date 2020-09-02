package leetcode;
//https://leetcode.com/problems/reorder-list/
public class reorder_list {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		reorder_list ob1= new reorder_list();
		ob1.reorderList(root);
		while(root!=null) {
			System.out.print(root.val);
			root=root.next;
		}
	}
	public void reorderList(ListNode head) {
		 if(head == null || head.next == null) return ;
	        ListNode slowPtr = head, fastPtr = head;
	        ListNode prev = head;
			// splitting list
	        while(fastPtr != null && fastPtr.next != null){
	            prev = slowPtr;
	            slowPtr = slowPtr.next;
	            fastPtr = fastPtr.next.next;
	        }
	        prev.next = null;
			// reverse
	        ListNode rev = reverse(slowPtr);
	        ListNode ptr = head;
			// arrange alternatively
	        while(ptr != null){
	            ListNode t1 = ptr.next;
	            ListNode t2 = rev.next;
	            ptr.next = rev;
	            if(t1 != null)
	                rev.next = t1;
	            ptr = t1;
	            rev = t2;
	        }
	    }
	 public ListNode reverse(ListNode head){
	        ListNode p1 = head;
	        ListNode p2 = head.next;
	        p1.next = null;
	        while(p2 != null){
	            ListNode temp = p2.next;
	            p2.next = p1;
	            p1 = p2;
	            p2 = temp;
	        }
	        return p1;
	    }
	 
}
