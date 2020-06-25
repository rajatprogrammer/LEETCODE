/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
var removeKdigits = function (num, k) {
    if (num.length <= k) {
        return ("0")
    } else {
        let temp_num = [...num];
        debugger;
        temp_num = temp_num.sort((a, b) => {
            return (b - a);
        });
        debugger;
        console.log(temp_num);
        return "0";
    }
};

removeKdigits('14199', 3)