package leetcode;

import java.util.HashMap;

import org.omg.CORBA.MARSHAL;

//https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
public class subarray_prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,2,2,4,3};
		int target=3;
		System.out.print(minSumOfLengths(arr,target));
	}
	 public static int minSumOfLengths(int[] arr, int target) {
		 HashMap<Integer, Integer> hs = new  HashMap<Integer, Integer>();
		 hs.put(0,-1);
		 int resutl=Integer.MAX_VALUE,left=Integer.MAX_VALUE;
		 int sum=0;
		 for(int i=0;i<arr.length;i++) {
			 sum=sum+arr[i];
			 hs.put(sum, i);
		 }
		 sum=0;
		 for(int i=0;i<arr.length;i++) {
			 sum=sum+arr[i];
			 if(hs.containsKey(sum-target)) {
				 left = Math.min(left, i-hs.get(sum-target)); //for left check
			 }
			 if(hs.containsKey(sum+target) && left<Integer.MAX_VALUE) {
				 resutl = Math.min(resutl,hs.get(sum+target)-i+left); //check for non overlapping
			 }
		 } 
		 
		 return resutl==Integer.MAX_VALUE?-1:resutl;
	 }

}
