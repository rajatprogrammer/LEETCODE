package leetcode;
//https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
import java.util.HashMap;

public class largest_integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public String largestNumber(int[] cost, int target) {
		 HashMap<Integer,Integer> ob1 = new HashMap<Integer, Integer>();
		 int max=0;
		 String max_return = "0";
		 for(int i=0;i<cost.length;i++) {
			 ob1.put(i+1, cost[i]);
		 }
		 for(int i=1;i<=cost.length;i++) {
			 int cost1 = ob1.get(i); 
			 String temp_max="";
			 if(target%cost1==0) {
				 int p=0;
				 int check = target/cost1;
				 while(check>p) {
					 temp_max = temp_max + i;
					 ++p;
				 }
				 if(Integer.parseInt(max_return)<Integer.parseInt(temp_max)) {
					 max_return=temp_max;
					 temp_max="";
				 }
			 }else {
				 temp_max="";
				 int p=0;
				 int divisor = target/cost1;
				 int rem = target%cost1;
				 while(divisor>p) {
					 temp_max = temp_max + i;
					 ++p;
				 }
				 		 
			 }
			 
		 }
	        return max_return;

	 	}
}
