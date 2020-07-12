package leetcode;

import java.util.ArrayList;
import java.util.List;

public class subset {
	List<List<Integer>> output = new ArrayList();
	  int n, k;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3};
		subset ob1 =new subset();
		List<List<Integer>>s = ob1.subsets(nums);
	}
	public  List<List<Integer>> subsets(int[] nums) {
//		n = nums.length;
//	    for (k = 0; k < n + 1; ++k) {
//	      backtrack(0, new ArrayList<Integer>(), nums);
//	    }
//	    return output;
		ArrayList<List<Integer>> resul= new ArrayList<List<Integer>>();
		return sub(0, nums, resul);
		
    }
	 public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
		    // if the combination is done
		    if (curr.size() == k)
		      output.add(new ArrayList(curr));

		    for (int i = first; i < n; ++i) {
		      // add i into the current combination
		      curr.add(nums[i]);
		      // use next integers to complete the combination
		      backtrack(i + 1, curr, nums);
		      // backtrack
		      curr.remove(curr.size() - 1);
		    }
	 }
	 public ArrayList<List<Integer>>sub(int i,int nums[],ArrayList<List<Integer>> out){
		 if(i==nums.length-1) {
			 out.add(new ArrayList<Integer>());
			 ArrayList<Integer> as = new ArrayList<Integer>();
			 as.add(nums[i]);
			 out.add(as);
			 return out;
		 }else {
			 ArrayList<List<Integer>> backtrack=sub(i+1,nums,out);
			 int size = backtrack.size();
			 for(int k=0;k<size;k++) {
				 List<Integer> temp = new ArrayList<Integer>();
				 temp.addAll(backtrack.get(k));
				 temp.add(nums[i]);
				 backtrack.add(temp);
			 }
			 return backtrack;
		 }
	 }
}
