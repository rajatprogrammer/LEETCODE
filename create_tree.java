import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/add-one-row-to-tree/
public class create_tree {
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
		create_tree ob1 = new create_tree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(5);
		ob1.addOneRow(root, 1, 2);
	}
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if(d==1) {
			TreeNode temp = new TreeNode(v);
			temp.left = root;
			root=temp;
			return root;
		}
		else {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
			int level=1;
			while(!q.isEmpty()) {
				int size = q.size();
				while(size>0) {
					TreeNode data = q.poll();
					if(level+1==d) {
						TreeNode left = new TreeNode(v);
						TreeNode right = new TreeNode(v);
						TreeNode temp_left = data.left;
						TreeNode temp_right=data.right;
						data.left = left;
						data.left.left = temp_left;
						data.right = right;
						data.right.right=temp_right;
					}
					if(data.left!=null) {
						q.add(data.left);
					}
					if(data.right!=null) {
						q.add(data.right);
					}
					--size;	
				}
				++level;
			}
			return root;
		}
    }

}
