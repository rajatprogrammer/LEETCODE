package leetcode;

import java.util.LinkedList;
import java.util.Queue;
 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
public class invert_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public TreeNode invertTree(TreeNode root) {
	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.add(root);
	        while(!q.isEmpty()){
	            TreeNode temp = q.poll();
	            TreeNode left = temp.left;
	            temp.left = temp.right;
	            temp.right=left;
	            if(temp.left!=null){
	               q.add(temp.left); 
	            }
	            if(temp.right!=null){
	               q.add(temp.right); 
	            }
	        }
	        return root;
	    }

}
