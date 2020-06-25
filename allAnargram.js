//https://leetcode.com/problems/find-all-anagrams-in-a-string/
/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams1 = function (s, p) {
    let outputArray = [];
    p = p.split('');
    p = p.sort();
    p = p.join('');
    for (let i = 0; i < s.length; i++) {
        let substrPart = "";
        substrPart = s.substr(i, p.length);
        substrPart = substrPart.split('');
        substrPart = substrPart.sort();
        substrPart = substrPart.join('');
        if (p == substrPart) {
            outputArray.push(i);
        }
    }
    return outputArray;
};
var findAnagrams = function (s, p) {
    let outputArray = [];
    let map = new Array(26).fill(0);
    for (let k = 0; k < p.length; k++) {
        map[p.charCodeAt(k) - 97]++;
    }
    let windowStart = 0;
    let windowEnd = 0;
    while (windowEnd < s.length) {
        if (map[s.charCodeAt(windowEnd) - 97] > 0) {
            map[s.charCodeAt(windowEnd++) - 97]--;
            if (windowEnd - windowStart == p.length) {
                outputArray.push(windowStart);
            }
        } else if (windowStart == windowEnd) {
            windowStart++;
            windowEnd++;
        } else {
            map[s.charCodeAt(windowStart++) - 97]++;
        }
    }
    return outputArray;
};

console.log(findAnagrams("cbaebabacd", "abc"));


//console.log(findAnagrams1("cbaebabacd", "abc"));