package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class median_stream {
		
//	class heapData{
//		int data;
//		int index;
//		public heapData(int data,int index) {
//			this.data =data;
//			this.index=index;
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,-1,-3};
		System.out.print(Arrays.toString(medianSlidingWindow(nums,3)));
	}
	
	 public static  double[] medianSlidingWindow(int[] nums, int k) {
		 double[] out = new double[nums.length-k+1];
		 Queue<Integer> max = new PriorityQueue<Integer>();
		 Queue<Integer> min = new PriorityQueue<Integer>(Collections.reverseOrder());
		 double median = nums[0];
		 int count=1;
		 int itr=0;
		 for(int i=1;i<nums.length;i++) {
			 if(count==k) {
				 out[itr]=median;
				 itr++;
				 i=i-k+2;
				 median=nums[i];
				 min.clear();
				 max.clear();
				 count=0;
			 }
			 else {
				 if(min.size()>max.size()) {
					 if(nums[i] < median) 
		                { 
		                    max.add(min.remove()); 
		                    min.add(nums[i]); 
		                } 
		                else {
		                	 max.add(nums[i]); 
		                }
					 	median = (double)(min.peek() + max.peek())/2; 
					 
				 }else if(min.size()==max.size()) {
					 if(nums[i] < median) 
		                { 
		                    min.add(nums[i]); 
		                    median = (double)min.peek(); 
		                } 
		                else
		                { 
		                    max.add(nums[i]); 
		                    median = (double)max.peek(); 
		                } 
					 
				 }else {
					 if(nums[i] > median) 
		                { 
		                    min.add(max.remove()); 
		                    max.add(nums[i]); 
		                } 
		                else {
		                	 min.add(nums[i]); 
		                }
		                   
					 median = (double)(min.peek() + max.peek())/2; 
				 }
			 }
			 ++count;
		 }
	      return out; 
	 }

}
