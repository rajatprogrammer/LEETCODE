package leetcode;
//https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/submissions/
public class good_leaf_node_pair {
	int result=0;
	  static class TreeNode {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root =  new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		good_leaf_node_pair ob1 = new good_leaf_node_pair();
		int count = ob1.countPairs(root,3);
		System.out.print(count);
	}
	 public int countPairs(TreeNode root, int distance) {
	        dfs(root,distance);
	        return result;
	  }
	public int[] dfs(TreeNode root,int distance) {
		if(root == null) {
			 return new int[distance+1];
		} 
		 if(root.left == null && root.right == null){
	            int res[] = new int[distance+1];
	            res[1]++;
	            return res;
	     }
		 int[] left = dfs(root.left,distance);
	     int[] right = dfs(root.right,distance);
	     for(int i=1;i<left.length;i++) {
	    	 for(int j=1;j<right.length;j++) {
	    		 if(i+j <=distance) {
	    			 result += left[i]*right[j];
	    		 }
	                
	    	 }
	     }
	     //result
	     int res[] = new int[distance+1];
	   //shift by 1 because pass call to other recursion
	        for(int i=res.length-2;i>=1;i--){
	            res[i+1] = left[i]+right[i];
	        }
	        return res;
	}

}
