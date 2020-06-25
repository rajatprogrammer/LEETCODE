/**
 * initialize your data structure here.
 */
let top = 0;
let stack = [];
let min_stack = [];
var MinStack = function () {
    console.log("create MinSTack");
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function (x) {
    let val = top;
    top = top + 1;
    stack[val] = x;
    if (val == 0) {
        min_stack[val] = x;
    } else {
        if (x < min_stack[val - 1]) {
            min_stack[val] = x;
        } else {
            min_stack[val] = min_stack[val - 1];
        }
    }
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function () {
    stack.pop();
    min_stack.pop();
    top = stack.length - 1;
};

/**
 * @return {number}
 */
MinStack.prototype.top = function (opr) {
    return top;
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function () {
    return min_stack[min_stack.length - 1];
};

var Map1 = new Map();
Map1.has()