package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class arrayintosubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4,4,5};
		System.out.print(isPossibleRajat(nums));
		System.out.print(isPossible(nums));
	}
	 public static boolean isPossibleRajat(int[] nums) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i=0;i<nums.length;i++){
	            pq.add(nums[i]);
	        }
	        List<HashSet>data = new ArrayList<HashSet>();
	        int prev=pq.poll();
	        HashSet<Integer> set = new HashSet<>();
	        set.add(prev);
	        boolean point;
	        while(!pq.isEmpty()){
	          int curr=pq.poll();
	           if(curr==prev){
	               point=false;
	              for(int count=0;count<data.size();count++){
	                  HashSet ff = data.get(count);
	                  if(!ff.contains(curr)){
	                   ff.add(curr);
	                   point=true;   
	                   break;   
	                }
	              }
	                if((set.size()<=2) && !point){
	                   return false;
	               }else{
	                   if(!point){
	                        data.add(set);
	                    set=new HashSet<>();
	                    set.add(curr);
	                   } 
	                  
	               }
	           }
	           if(prev+1==curr){
	               set.add(curr);
	           }
	           prev=curr; 
	        }
	        if(set.size()>=3){
	            return true;
	        }else{
	          return false;  
	        }
	    }
	 
	 public static boolean isPossible(int[] nums) {
	        // Store the frequency of each number
	        Map<Integer, Integer> freq = new HashMap<>();
	        // Store the frequency of subsequence that ends at a certain number
	        Map<Integer, Integer> end = new HashMap<>();
	        // Get the frequency of each number of the original array
	        for (int n : nums)
	            freq.put(n, freq.getOrDefault(n, 0) + 1);
	        for (int n : nums) {
	            // Skip if we have used up the current number
	            if (freq.get(n) == 0) continue;
	            // Check whether there is a subsequence that ends at n - 1
	            else if (end.getOrDefault(n, 0) > 0) {
	                end.put(n, end.get(n) - 1);
	                end.put(n + 1, end.getOrDefault(n + 1, 0) + 1);
	            }
	            // If not, check whether we can use the current number as the start for a new subsequence
	            else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
	                freq.put(n + 1, freq.get(n + 1) - 1);
	                freq.put(n + 2, freq.get(n + 2) - 1);
	                end.put(n + 3, end.getOrDefault(n + 3, 0) + 1);
	            }
	            else return false;
	            freq.put(n, freq.get(n) - 1);
	        }
	        return true;
	    }

}
