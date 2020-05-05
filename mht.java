import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// https://leetcode.com/problems/minimum-height-trees/
public class mht {
	int top_count=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mht ob1 = new mht();
		int a1 [][] =  {{1,0}, {1, 2}, {1, 3}};
		List<Integer> output=ob1.findMinHeightTrees(5,a1);
		for(Integer c : output) {
			System.out.print(c + "->");
		}
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	      List<int[]> ed =  Arrays.asList(edges);
		 ArrayList<Integer> ob23 = new ArrayList<Integer>();
		 if(n<2) {
	         ob23.add(0);
			 return ob23;
		 }
		 n=ed.size();
		 if(n<2) {
			 ob23.add(edges[0][0]);
			 ob23.add(edges[0][1]);
			 return ob23;
		 }
		int root=0;
		int r1=0,r2=0;
	        for(int i=1;i<n;i++) {
	        	for(int j=0;j<2;j++) {
	        		if(edges[i][j]==edges[0][0]) {
	        			r1++;
	        		}
	        		else if(edges[i][j]==edges[0][1]) {
	        			r2++;
	        		}
	        	}
	        }
	        if(r1>r2) {
	        root=edges[0][0];
	        }else {
	        	root = edges[0][1];
	        }
	        ob23.add(root);
	        ArrayList<Integer> temp = new ArrayList<Integer>();
	        temp.addAll(checkEdge(edges, root, n, top_count));
	        	if(temp.size()==0) {
	        		return ob23;
	        	}else {
	        		for(int k=0;k<temp.size();k++) {
	        			List<Integer> ob21 = checkEdge(edges, temp.get(k), n, top_count);
	        			if(ob21.size()==0) {
	        				temp.remove(k);
	                        k--;
	        			}else {
	        				ob23.add(temp.get(k));
	        				temp.addAll(ob21);
	        				temp.remove(k);
	        			}
	        		}
	        	}
				return ob23;
	     
	    
	    }
	    public List<Integer> checkEdge(int[][] edges,int root,int n,int loop) {
		 ArrayList<Integer> ob1 = new ArrayList<Integer>();
		 for(int i=loop;i<n;i++) {
	  		if(edges[i][0]==root) {
	  			ob1.add(edges[i][1]);
	  			top_count = i+1;
	  			continue;
	  		}
	  		else if(edges[i][1]==root) {
	  			ob1.add(edges[i][0]);
	  			top_count = i+1;
	  			continue;
	  		}else {
	  			top_count = i;
	  			break;
	  		}
		}
		 return ob1;
	 } 
}
