
  function TreeNode(val, left, right) {
      this.val = (val===undefined ? 0 : val)
      this.left = (left===undefined ? null : left)
      this.right = (right===undefined ? null : right)
 }
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumRootToLeaf = function(root) {
    return TreeTraverse(root,'');
};

function TreeTraverse(root,str){
    debugger;
    if(root==null){
        return null;
    }
    else if(root.left==null && root.right==null){
      debugger;
      str = str + root.val;
      return parseInt(str, 2);
    }
    else{
        debugger;
        let left = TreeTraverse(root.left, str + root.val);
        let right = TreeTraverse(root.right, str + root.val);
        if(left!=null && right!=null){
            return (left+right);
        }
        if(left==null){
            return right;
        }
        return left;
    }
    
}
let root = new TreeNode(1);
//root.left = new TreeNode(0);
root.right = new TreeNode(0);
// root.right.right = new TreeNode(1);
// root.left.left =new TreeNode(0);
// root.left.right = new TreeNode(1);
// root.right.left = new TreeNode(0);

console.log(sumRootToLeaf(root));