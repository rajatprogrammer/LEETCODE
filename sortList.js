  //merge sort in singly link list
  function ListNode(val, next) {
      this.val = (val===undefined ? 0 : val)
      this.next = (next===undefined ? null : next)
 }
 
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    if(head == null || head.next == null) return head;
    let mid =  midList(head);
    let left = sortList(head);
    let right= sortList(mid);
    return merge(left,right);
};

var midList = function(head){
    let fast=head,slow=head,mid=null;
    while(fast.next!=null && fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    mid=slow.next;
    slow.next=null;
    return mid;
}

var merge = function(head1,head2){
    let node=new ListNode();
    let current=node;
    while(head1!=null && head2!=null){
        if(head1.val>=head2.val){
            current.next=head2;
            head2=head2.next;
        }else{
            current.next=head1;
            head1 = head1.next;
        }
            current=current.next;
    }
    if(head1!=null){
        current.next=head1;   
    }
    if(head2!=null){
        current.next=head2;
    }
    return node.next;
}

let root = new ListNode(4);
root.next= new ListNode(2);
root.next.next= new ListNode(1);
root.next.next.next=new ListNode(3);

let output = sortList(root);

while(output!=null){
    console.log(output.val + "->")
    output=output.next;
}