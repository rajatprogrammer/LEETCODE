//https://leetcode.com/problems/possible-bipartition/
var possibleBipartition = function (N, dislikes) {
    let group11 = new Set();
    let group22 = new Set();
    let s = new Map();
    for (let i = 0; i < dislikes.length; i++) {
        if (s.has(i)) {
            let data = s.get(i);
            data.set(dislikes[i][1], true);
            s.set(dislikes[i][0], data);
        } else {
            s.set(dislikes[i][0], new Map().set(dislikes[i][1], true));
        }

    }
    // debugger;
    for (let i = 1; i <= N; i++) {
        // debugger;
        let group1 = true;
        let group2 = true;
        let check1 = 0;
        let check2 = 0;
        group11.forEach((elem) => {
            //   debugger;
            if (!group1) {
                return true;
            }
            if (s.get(elem) && s.get(elem).get(i)) {
                debugger;
                check1 = elem;
                group1 = false;
            }
        });
        group22.forEach((elem) => {
            //debugger;
            if (!group2) {
                return true;
            }
            if (s.get(elem) && s.get(elem).get(i)) {
                debugger;
                check2 = elem;
                group2 = false;
            }
        });
        if (group2) {
            group22.add(i);
        } else {
            if (group1) {
                group11.add(i);
            }
        }
        if (!group2 && !group1 && ((s.get(check1).get(check2)) || (s.get(check2).get(check1)))) {
            return false;
        } else if (!group2 && !group1) {
            return false;
        }
    }
    return true;
};

console.log(possibleBipartition(10, [
    [6, 9],
    [1, 3],
    [4, 8],
    [5, 6],
    [2, 8],
    [4, 7],
    [8, 9],
    [2, 5],
    [5, 8],
    [1, 2],
    [6, 7],
    [3, 10],
    [8, 10],
    [1, 5],
    [3, 6],
    [1, 10],
    [7, 9],
    [4, 10],
    [7, 10],
    [1, 4],
    [9, 10],
    [4, 6],
    [2, 7],
    [6, 8],
    [5, 7],
    [3, 8],
    [1, 8],
    [1, 7],
    [7, 8],
    [2, 4]
]));