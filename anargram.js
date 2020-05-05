/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var map = {};
var groupAnagrams = function (strs) {
    var map = {};
    var output = [];
    if (strs.length < 1) {
        return output;
    }
    for (let i = 0; i < strs.length; i++) {
        let uniqueKey = (Array.from(strs[i]).sort()).join("");
        if (map[uniqueKey]) {
            map[uniqueKey].push(strs[i]);

        } else {
            map[uniqueKey] = [strs[i]];
        }
    }
    Object.keys(map).forEach(elem => {
        output.push(map[elem].sort());
    })

    return output;


}
groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]);