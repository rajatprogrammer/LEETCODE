package leetcode;
//https://leetcode.com/problems/perfect-squares/

public class PerfectSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// numSquares(12);
		int square[] = {1,4,9,25}; // passing squre root
		System.out.print(recursive(40,square,0,0));
	}
	//dynamic programming
	public static int numSquares(int n) {
		 int result[] = new int[n+1];
		    for(int i=1;i<result.length;i++){
		        result[i] = Integer.MAX_VALUE;
		    }    
		    for (int i = 1; i <= n; i++) {
		        for (int j = 1; j * j <= i; j++) {
		            result[i] = Math.min(result[i], result[i - j * j] + 1);
		        }
		    }
		    for(int i=0;i<result.length;i++) {
		    	System.out.print(result[i] + "-");
		    }
		        return result[n];
	
	}
	
	public static int recursive(int n,int square[],int count,int i) {
		if(n==0) {
			return count;
		}
		if(i>square.length-1) {
			return count;
		}
		if(n<-1) {
			return 0;
		}else {
			int min = Math.min(recursive(n-square[i],square,count,i),recursive(n,square,count,i+1));
			return (min+1);
		}
	}

}
