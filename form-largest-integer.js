//https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

/**
 * @param {number[]} cost
 * @param {number} target
 * @return {string}
 */
var largestNumber = function (cost, target) {
    const arr = new Array(target + 1).fill('#');
    arr[0] = '';

    for (let i = 0; i < 9; i++) {
        for (let j = cost[i]; j <= target; j++) {
            if (arr[j - cost[i]] !== '#' && arr[j - cost[i]].length + 1 >= arr[j].length) {
                arr[j] = (i + 1).toString().concat(arr[j - cost[i]]);
            }
        }
    }

    return arr[target] == '#' ? '0' : arr[target];
};

console.log(largestNumber([4, 3, 2, 5, 6, 7, 2, 5, 5], 9));