package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class width_tree {
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(7);
		width_tree ob1 = new width_tree();
		System.out.print(ob1.widthOfBinaryTree(root));
	}
	public int widthOfBinaryTree(TreeNode root) {
		List<TreeNode>  q = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int level=0;
        int max=0;
        boolean stop=true;
        map.put(level,0);
        q.add(root);
        while(!q.isEmpty() && stop){
            int size=q.size();
            int width=0;
            int count=0;
            for(int i=0;i<size;i++){ 
                TreeNode temp = q.remove(0);
                if(temp!=null) {
                	q.add(temp.left);
                    q.add(temp.right); 	
                }
                if(temp==null){
                q.add(temp);
                q.add(temp);
                    count++;
                }
                width++;
            }
            if(count==size){
               stop=false; 
            }else{
                map.put(level,width);
                if(width>max){
                    max=width;
                }
            }
            while(!q.isEmpty() && q.get(0) == null){
                q.remove(0);
            }
            // trim the queue from right
            while(!q.isEmpty() && q.get(q.size()-1) == null){
                q.remove(q.size()-1);
            }
            level++;
            
        }
        return max;   
    }
	

}
