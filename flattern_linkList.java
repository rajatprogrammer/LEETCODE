package leetcode;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node(int val) {
    	this.val=val;
    	prev=null;
    	child=null;
    	next=null;
    }
};
//https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
public class flattern_linkList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.prev = root;
		root.next.next =new Node(3);
		root.next.next.prev = root.next.next;
		root.next.child = new Node(8);
		root.next.child.next = new Node(9);
		root.next.child.prev=root.next.child;
		flattern_linkList ob1 = new flattern_linkList();
		Node data =ob1.flatten(root);
		while(data!=null) {
			System.out.print(data.val + "-->");
			data=data.next;
		}
		
	}
	 public Node flatten(Node head) {
		 	if(head==null) {
		 		return head;
		 	}
	        Node next=head;
	        while(next.next!=null){
	            if(next.child!=null){
	               Node temp=flatten(next.child);
	               Node temp_tail=tail(temp);
	               Node tt = next.next;
	               next.next=temp;
	               temp.prev=next; 
	               temp_tail.next=tt;
	               tt.prev=temp_tail;
	               next.child=null; 
	            }
	            next=next.next;
	        }
	        return head;
	    }
	    public Node tail(Node head){
	        while(head.next!=null){
	            head=head.next;
	        }
	        return head;
	    }

}
