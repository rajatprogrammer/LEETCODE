/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function (nums) {
    if (nums.length < 1) {
        return 0;
    }
    let keys1 = {};
    let map1 = new Map();
    for (let k = 0; k < nums.length; k++) {
        if (map1.has(nums[k])) {
            map1.set(nums[k], (map1.get(nums[k]) + nums[k]))
        } else {
            keys1[nums[k]] = 1;
            map1.set(nums[k], nums[k]);
        }
    }
    map1 = new Map([...map1.entries()].sort((a, b) => b[1] - a[1]));
    let max = 0;
    while (map1.size > 0) {
        let elem = map1.keys().next().value;
        if (map1.has(elem + 1) && map1.has(elem - 1)) {
            let t1 = map1.get(elem + 1);
            let t2 = map1.get(elem - 1);
            if (t1 == t2) {
                map1.delete(elem - 1);
            } else if (t1 > t2) {
                map1.delete(elem - 1);
            } else {
                map1.delete(elem + 1);
            }
        } else if (map1.has(elem - 1)) {
            map1.delete(elem - 1);
        } else if (map1.has(elem + 1)) {
            map1.delete(elem + 1);
        }
        let temp = map1.get(elem) - elem;
        if (temp) {
            map1.set(elem, temp);
            max = max + elem;
            map1 = new Map([...map1.entries()].sort((a, b) => b[1] - a[1]));
        } else {
            map1.delete(elem);
            max = max + elem;
        }
    }
    console.log(max);
    return max;
};
deleteAndEarn([8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4]);