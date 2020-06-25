/**
 * @param {string} s
 * @return {number}
 */
var maxPower = function (s) {
    let max = 1;
    let temp = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i - 1] == s[i]) {
            temp = temp + 1;
            if (temp > max) {
                max = temp;
            }
        } else {
            temp = 1;
        }
    }
    return max;
};
console.log(maxPower("abbcccddddeeeeedcba"));