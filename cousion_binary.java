import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree/

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


public class cousion_binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		//root.left.right.left = new TreeNode(6);
		System.out.print(isCousins(root,4,5));
	}
	
	public static boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
       Queue<TreeNode>q = new LinkedList<TreeNode>(); 
       Map<Integer,Integer> ob1 = new HashMap<Integer,Integer>();
       Map<Integer,Integer> level = new HashMap<Integer,Integer>();
       ob1.put(root.val,0);
       level.put(root.val,0);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.left!=null) {
            	q.add(temp.left);
            	ob1.put(temp.left.val,temp.val);
            	level.put(temp.left.val,level.get(temp.val)+1);
            }
            if(temp.right!=null) {
            	 q.add(temp.right);
            	 ob1.put(temp.right.val,temp.val);
            	 level.put(temp.right.val, level.get(temp.val)+1);
            }
        }
        
       if(!level.containsKey(x) || !level.containsKey(y)) {
    	   return false;
       }
       if(level.get(x)!=level.get(y)) {
    	   return false;
       }
       if(ob1.get(x)==ob1.get(y)) {
    	   return false;
       }
       int parent1 = ob1.get(x);
       int parent2 = ob1.get(y);
//       while(level.get(ob1.get(parent1))>0 ||level.get(ob1.get(parent2))>0) {
//    	  parent1 = ob1.get(parent1); 
//    	  parent2 = ob1.get(parent2);
//       }
      if(parent1!=parent2) {
    	  return true;
      }else {
    	  return false;
      }
        
    }

}
