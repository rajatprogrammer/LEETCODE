/**
 * @param {string} S
 * @param {string} T
 * @return {boolean}
 */
var backspaceCompare = function (S, T) {
    if (S == "" && T == "") {
        return true;
    }
    let temp1 = "";
    let temp2 = "";
    for (let k = 0; k < S.length; k++) {
        if (S[k] != "#") {
            temp1 = temp1 + S[k];
        } else {
            if (temp1 != "") {
                temp1 = temp1.substr(0, temp1.length - 1);
            }
        }
    }
    for (let k = 0; k < T.length; k++) {
        if (T[k] != "#") {
            temp2 = temp2 + T[k];
        } else {
            if (temp2 != "") {
                temp2 = temp2.substr(0, temp2.length - 1);
            }
        }
    }
    if (temp1 == temp2) {
        return true;
    } else {
        return false;
    }

};

console.log(backspaceCompare("a#c", "b"));