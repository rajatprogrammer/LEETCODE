package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
//https://leetcode.com/problems/sliding-window-median/
public class median_stream {		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,-1,-3,5,3,6,7};
		System.out.print(Arrays.toString(medianSlidingWindow(nums,3)));
	}
	
	public static   double[] medianSlidingWindow(int[] nums, int k) {
	       int n = nums.length;
	        if(n == 0 || k == 0)
	            return new double[0];
	                
	        double[] result = new double[n - k + 1];
	        //for upper half of the ordered list
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	        //for lower half of the ordered list
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); 
	        
	        for(int i = 0; i < n; i++) {
	                       
	            if(minHeap.size() > 0 && nums[i] > minHeap.peek())
	                minHeap.add(nums[i]);    
	            else 
	                maxHeap.add(nums[i]);
	            
	            balanceHeaps(minHeap, maxHeap);
	            
	            if(i >= k - 1){
	                
	                result[i - k + 1] = getMedian(minHeap, maxHeap);
	                
	                //heaps should have elements only belonging to the sliding window 
	                if(nums[i - k + 1] <= maxHeap.peek())
	                    maxHeap.remove(nums[i - k + 1]);
	                else
	                    minHeap.remove(nums[i - k + 1]);
	                
	                balanceHeaps(minHeap, maxHeap);
	            } 
	        }
	        return result;
	    }
	    
	    private static void balanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
	        if(minHeap.size() - maxHeap.size() > 1) {
	            int value = minHeap.poll();
	            maxHeap.add(value);
	        } else if(maxHeap.size() - minHeap.size() > 1) {
	            int value = maxHeap.poll();
	            minHeap.add(value);
	        }
	    }
	    
	    private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
	        
	        double median = 0.0;
	        if(minHeap.size() == maxHeap.size())
	            median = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
	        else if (minHeap.size() > maxHeap.size())
	            median = minHeap.peek();
	        else 
	            median = maxHeap.peek(); 
	        
	        return median;
	    }
}
