package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/interval-list-intersections/
public class intersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = {{4,6},{7,8},{10,17}};
		int B[][] = {{5,10}};	
		int result[][] = intervalIntersection(A,B);
	}
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		if(A.length<=0 || B.length<=0){
            return(new int[0][0]);
        }
        int onePtr=0 ;
		int twoPtr=0;
		List<Integer []> result = new ArrayList<Integer []>();
		int [][] finalResult;
		while(onePtr<A.length && twoPtr<B.length) {
//			if(A[onePtr][1]>=B[twoPtr][1] && ) {
//				
//			}else if(A[onePtr][1]<B[twoPtr][1]) {
//				
//			}	
			if(A[onePtr][1]>=B[twoPtr][1] && A[onePtr][0]<=B[twoPtr][1]) {
				if(A[onePtr][0]<=B[twoPtr][0] && A[onePtr][1]<=B[twoPtr][1]) {
					Integer[]  temp = new Integer[2];
					temp[0]=Math.max(A[onePtr][0],B[twoPtr][0]);
					temp[1]=Math.min(A[onePtr][1],B[twoPtr][1]);
					result.add(temp);	
					onePtr++;
					
				}else {
					Integer[]  temp = new Integer[2];
					temp[0]=Math.max(A[onePtr][0],B[twoPtr][0]);
					temp[1]=Math.min(A[onePtr][1],B[twoPtr][1]);
					result.add(temp);	
					twoPtr++;
				}
			}else if(A[onePtr][1]<B[twoPtr][1] && A[onePtr][1]>=B[twoPtr][0]) {
				if(A[onePtr][0]>=B[twoPtr][0] && A[onePtr][1]>=B[twoPtr][1]) {
					Integer[]  temp = new Integer[2];
					temp[0]=Math.max(A[onePtr][0],B[twoPtr][0]);
					temp[1]=Math.min(A[onePtr][1],B[twoPtr][1]);
					result.add(temp);	
					twoPtr++;
				}else {
					Integer[]  temp = new Integer[2];
					temp[0]=Math.max(A[onePtr][0],B[twoPtr][0]);
					temp[1]=Math.min(A[onePtr][1],B[twoPtr][1]);
					result.add(temp);
					onePtr++;
				}
			}else {
				if(A[onePtr][1]>=B[twoPtr][1]) {
					twoPtr++;
				}else {
					onePtr++;
				}
			}
		}
        if(twoPtr<B.length) {
        	twoPtr++;
        	while(twoPtr<B.length && A[A.length-1][1]>= B[twoPtr][1]) {
    			Integer[]  temp = new Integer[2];
    			temp[0]=B[twoPtr][0];
    			temp[1]=B[twoPtr][1];
    			result.add(temp);	
    			twoPtr++;
    		}
        }
        if(onePtr<A.length) {
        	onePtr++;
        	while(onePtr<A.length && B[B.length-1][1]>= A[onePtr][1] ) {
    			Integer[]  temp = new Integer[2];
    			temp[0]=A[onePtr][0];
    			temp[1]=A[onePtr][1];
    			result.add(temp);	
    			onePtr++;
    		}	
        }
		
		finalResult = new int[result.size()][2];
		int resultCount = 0;
		for(Integer x []:result) {
			finalResult[resultCount][0] = x[0];
			finalResult[resultCount][1] = x[1];
			resultCount++;
		}
		
       return finalResult; 
    }
}
