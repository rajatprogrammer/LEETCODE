package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 class TreeNode1 {
	      int val;
	      TreeNode1 left;
	      TreeNode1 right;
	      TreeNode1() {}
	      TreeNode1(int val) { this.val = val; }
	      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
public class level_order_travsersal_revearse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode1  root = new TreeNode1();
		levelOrderBottom(root);
	}
	public static List<List<Integer>> levelOrderBottom(TreeNode1 root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }else{
            Queue<TreeNode1> q = new LinkedList<>();
            q.add(root);
            while(q.size()>0){
                 List<Integer> temp = new ArrayList<>();
                int size = q.size();
                for(int i=0;i<size;i++){
                	TreeNode1 data = q.poll();
                    temp.add(data.val);
                    if(data.left!=null){
                        q.add(data.left);
                    }
                 if(data.right!=null){
                    q.add(data.right);
                    }
                }
                result.add(0,temp);
            }
    }
          return result; 
}	

}
