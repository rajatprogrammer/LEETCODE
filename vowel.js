// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function (s, k) {
    // let map = new Map();
    // map.add('a', 0);
    // map.add('e', 0);
    // map.add('i', 0);
    // map.add('o', 0);
    // map.add('u', 0);
    let count = 0;
    let max = 0;
    let temp_max = 0;
    for (let i = 0; i < s.length; i++) {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'o' || s[i] == 'i' || s[i] == 'u') {
            count = count + 1;
            temp_max = temp_max + 1;
            if (temp_max > max) {
                max = temp_max;
            }
        } else {
            temp_max = 0;
        }

    }
    let m = Math.max(count, max);
    if (m == count && max < k) {
        max = count - max;
    }
    if (max >= k) {
        return k;
    } else {
        return max;
    }
}

console.log(maxVowels("tryhard", 1));