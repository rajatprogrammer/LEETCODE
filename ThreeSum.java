package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	static List<List<Integer>> ans = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-1,0,1,2,-1,-4};
		List<List<Integer>> xx=threeSum(nums);
		for(List<Integer>xs:xx) {
			System.out.println(xs);
		}
		
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int len =nums.length;
		for(int i=0;i<nums.length;i++) {
			int sum=-nums[i];
			 int left = i+1;
	         int right = len-1;
	         while(left<right) {
	        	if(nums[left]+nums[right]==sum) {
	        		ArrayList<Integer> les = new ArrayList<Integer>();
	        		les.add(nums[i]);
	        		les.add(nums[left]);
	        		les.add(nums[right]);
	        		 boolean check=false;
	                    for(List<Integer>st:ans){
	                        if(st.equals(les)){
	                            check=true;
	                        }
	                    }
	                    if(!check){
	                      ans.add(les);   
	                    }
	                    left++;
	                    right--;
	        	}else if(nums[left]+nums[right]>sum) {
	        		right--;
	        	}else {
	        		left++;
	        	}
	         }	          
		}
		return ans;
	}

}
