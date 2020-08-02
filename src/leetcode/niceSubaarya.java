package leetcode;

import java.util.HashMap;
import java.util.Map;

public class niceSubaarya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,2,1,1};
		int k=3;
		System.out.print(numberOfSubarrays(arr,k));
	}
	// actual solutiin is different
	public static int numberOfSubarrays(int[] nums, int k) {

		Map<Integer,Integer> countMap = new HashMap<>();
		    
		  int oddsum= 0;
		    int count =0;
		    
		    for(int i=0;i< nums.length;i++)
		    {
		    
		        if(nums[i]%2 ==1)
		           oddsum++;
		        
		        if(oddsum==k)
		            count++;
		        
		        if(countMap.get(oddsum-k) !=null)
		        count = count+ countMap.get(oddsum-k);
		        
		        if(countMap.get(oddsum) == null)
		            countMap.put(oddsum , 1);
		        
		        else
		        {
		            countMap.put(oddsum , countMap.get(oddsum)+1);

		          }
		        
		    }
		return count;
		    
		    
		    
		}
}
