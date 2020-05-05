import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/solution/
public class count_kmax {
	public static void main(String args[]) {
		count_kmax ob1 = new count_kmax();
		int arr[]= {1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2}; 
			//{-1,-1,1},0 ;
			//{1,2,3,2,3,2,3,1,3,2};,3
			//{3,3,3,3,4,5,5,3,3,3,5,6,2,1,4,5,3,1,1,1,3}; ,3
			//{1,1,1},2
		System.out.println(ob1.subarraySum1(arr,6));
	}
	public int subarraySum(int[] arr, int k) {
        int count=0;
        int total_max=0;
        if(arr.length<2){
            if(arr[0]==k){
                count++;
                return count;
            }else{
                return count;
            }
        }
        for(int i=0;i<arr.length;i++){
        	if(arr[i]==k) {
        		count++;
        		total_max=0;
        		continue;
        	}
        	if(i>0 && (arr[i-1]+arr[i]==k)){
                count++;
                total_max=0;
                continue;
            }
              total_max = total_max+arr[i]; 
             if(total_max>k){
                total_max=0;
               total_max=arr[i];
            }else if(total_max==k){
                total_max=arr[i];
                count++;
            }
    }
        return count;
    }
	//optimized sum for count_max
	 public int subarraySum1(int[] nums, int k) {
         int sum = 0, result = 0;
  Map<Integer, Integer> preSum = new HashMap<>();
  preSum.put(0, 1);
  
  for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      System.out.println("sum is" +sum );
      if (preSum.containsKey(sum - k)) {
    	  System.out.println("sum found" +(sum - k ));
          result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
  }
  
  return result;
}
//o(n2) approach
	 
}


