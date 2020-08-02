package leetcode;

public class good_node {
	  public static class TreeNode {
	     int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { 
	    	  this.val = val;
	    	  this.left = null;
	    	  this.right = null;
	      }
	      public int goodNodes(TreeNode root) {
	    	  if(root.left==null && root.right==null) {
	    		  return 1;
	    	  }else {
	    		  return goodNodeHelper(root,root.val,0);  
	    	  }
	        }
	    	
	    	public int goodNodeHelper(TreeNode root,int rootData,int max) {
	    		if(root==null) {
	    	    	  return 0; 
	    	    }else {
	    	    	 int lgood = goodNodeHelper(root.left,Math.max(rootData, root.val),max);
	    	    	  int rgood = goodNodeHelper(root.right,Math.max(rootData, root.val),max);
	    	    	  if(root.val>=rootData) {
		    	    		max = max +1;
		    	    	}
	    	    	  return (max + lgood + rgood);
	    	    }
	    	}
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(9);
//		root.left = new TreeNode(1);
//		root.left.left = new TreeNode(3);
//		// root.left.right = new TreeNode(2);
//		root.right = new TreeNode(4);
//		root.right.left = new TreeNode(1);
//		root.right.right = new TreeNode(5);
		root.right= new TreeNode(6);
		root.right.left = new TreeNode(3);
		System.out.print(root.goodNodes(root));
	}

}
