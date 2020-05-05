function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function (root) {
    if (root == null || (root.left == null && root.right == null)) {
        return 0;
    } else {
        let lh_h = height(root.left);
        let rh_h = height(root.right);
        let diam_h = diameterOfBinaryTree(root.left);
        let diam_r = diameterOfBinaryTree(root.right);
        let check = Math.max(Math.max(diam_h, diam_r), lh_h + rh_h + 1);
        return check;

    }
};

function height(root) {
    if (root == null) {
        return 0;
    } else {
        let lh = height(root.left);
        let rh = height(root.right);
        if (lh > rh) {
            return (lh + 1);
        } else {
            return (rh + 1);
        }
    }
}

let root = new TreeNode(1);
root.left = new TreeNode(3);
root.right = new TreeNode(4);
root.right.right = new TreeNode(5);
root.right.right.left = new TreeNode(7);
root.right.right.right = new TreeNode(6);
root.right.right.left.right = new TreeNode(8);
root.right.right.left.right.right = new TreeNode(10);
root.right.right.left.right.right.right = new TreeNode(12);
root.right.right.right.right = new TreeNode(9);
root.right.right.right.right.right = new TreeNode(11);

// let root = new TreeNode(1);
// root.left = new TreeNode(2);
// root.left.left = new TreeNode(3);
console.log(diameterOfBinaryTree(root));