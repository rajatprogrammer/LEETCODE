/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

// function ListNode(val) {
//     this.val = val;
//     this.next = null;
// }
// /**
//  * @param {ListNode} head
//  * @return {ListNode}
//  */
// var middleNode = function (head) {

//     let ptr_fast = head;
//     let ptr_slow = head;

//     while (ptr_fast && ptr_fast.next != null) {
//         ptr_slow = ptr_slow.next;
//         ptr_fast = ptr_fast.next.next;
//     }
//     return ptr_slow;

// };

// var lengthOfLongestSubstring = function (s) {
//     let charMap = {};
//     let Max_size = 0;
//     let currentSize = 0;
//     for (let k = 0; k < s.length; k++) {
//         if (charMap[s[k]] == undefined) {
//             prevIndex = -1;
//         } else {
//             prevIndex = charMap[s[k]];
//         }
//         if (prevIndex == -1 || k - currentSize > prevIndex) {
//             currentSize++;
//         } else {
//             if (currentSize > Max_size) {
//                 Max_size = currentSize;
//             }
//             currentSize = k - charMap[s[k]];
//         }
//         charMap[s[k]] = k;
//     };
//     if (currentSize > Max_size) {
//         Max_size = currentSize;
//     }
//     return Max_size;
// }

// console.log(lengthOfLongestSubstring("abcabcbb"));


/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
    n = `${n}`;
    let check = 0;
    let map = new Set();
    while (1) {
        if (map.has(n) == true) {
            return false;
        }
        for (i = 0; i < n.length; i++) {
            let k = parseInt(n[i]);
            check = check + k * k;
        }
        if (check == 1) {
            return true;
        }
        map.add(n);
        n = `${check}`;
        check = 0;
    }
};

console.log(isHappy(211));