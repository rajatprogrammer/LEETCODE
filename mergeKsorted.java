package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/merge-k-sorted-lists/
class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
public class mergeKsorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] ob1 = new ListNode[3];
		ob1[0] = new ListNode(1);
		ob1[0].next = new ListNode(4);
		ob1[0].next.next = new ListNode(5);
		ob1[1] = new ListNode(1);
		ob1[1].next = new ListNode(3);
		ob1[1].next.next = new ListNode(4);
		ob1[2] = new ListNode(2);
		ob1[2].next = new ListNode(6);
		mergeKsorted ob2 = new mergeKsorted();
		ob2.mergeKLists(ob1);
	}
		public ListNode mergeKLists(ListNode[] lists) {
	        if(lists.length<=0){
	            return null;
	        }
	        Queue<ListNode> hq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>() {
				 public int compare(ListNode ob1,ListNode ob2) {
					return ob1.val-ob2.val;
				}
			});
			
			for(int i=0;i<lists.length;i++) {
	            if(lists[i]!=null){
	                hq.add(lists[i]);
	            }
			}
			ListNode head = null;
			ListNode ptr = null;
			while(hq.size()>0) {
				ListNode temp = hq.poll();
	            if(temp.next!=null){
	             hq.add(temp.next);   
	            }
				if(head==null) {
					head = temp;
					ptr=head;
				}else {
					ptr.next=temp;
					ptr=temp;
				}
			}	
			return head;    
	    }

}
