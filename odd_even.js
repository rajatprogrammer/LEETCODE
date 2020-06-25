function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function (head) {
    let ptn = head;
    let oddNode = head;
    let evenNode = null;
    let count = 1;
    let temp
    while (ptn.next != null) {
        if (count % 2 != 0 && oddNode.val != ptn.val) {
            temp = oddNode.next;
            temp.next = ptn.next;
            oddNode.next = ptn;
            oddNode = ptn;
            ptn = temp;
        } else {
            if (count % 2 == 0) {
                if (evenNode == null) {
                    evenNode = temp ? temp : ptn;
                } else {
                    evenNode.next = temp;
                }
            }
            temp = null;
        }
        ptn = ptn.next;
        count = count + 1;
    }
    if (evenNode) {
        oddNode.next = evenNode;
    }
    return head;
};

let node = new ListNode(2);
node.next = new ListNode(1);
node.next.next = new ListNode(3);
//node.next.next.next = new ListNode(5);
//node.next.next.next.next = new ListNode(6);
//node.next.next.next.next.next = new ListNode(4);
//node.next.next.next.next.next.next = new ListNode(7);
//node.next.next.next.next.next.next.next = new ListNode(8);

let data = oddEvenList(node);

while (data != null) {
    console.log(data.val + "-->");
    data = data.next;
}