package leetcode;
// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class consecutive_number {
	ArrayList<Integer> res = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=2,K=1;
		consecutive_number ob1 =new consecutive_number();
		System.out.println(Arrays.toString(ob1.numsSameConsecDiff(N, K)));
	}
	public int[] numsSameConsecDiff(int N, int K) {
	     List<Integer> result = new ArrayList<Integer>();
	        if(N == 1) result.add(0);
	        for(int d = 1; d < 10; ++d)
	            dfs(d, N-1, K, result);
	        
	        return result.stream().mapToInt(i->i).toArray(); 
	    }
	   private void dfs(int num, int N, int K, List<Integer> result){
	        if(N == 0){
	            result.add(num);
	            return;
	        }
	        int last_digit = num%10;
	        if(last_digit >= K) dfs(num*10 + last_digit - K, N-1, K, result);
	        if(K > 0 && last_digit + K < 10) dfs(num*10 + last_digit + K, N-1, K, result);
	    }
}
