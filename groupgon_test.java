package leetcode;

import java.util.Arrays;

public class groupgon_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(check(8,2,0));
	}
	
	public static int check(int total,int k,int way) {
		if(k==0) {
			return way;
		}
		if(total==0) {
			return 1;
		}else if(total<0) {
			return 0;
		}else {
			int check = check(total-k,k,way)+check(total,--k,way) ;
			return check;
		}
	}
	
//	public static int dp(int total,int k) {
//		int table[] = new int[total+1];
//		table[0]=1;
//		for(int i=1;i<=total;i++) {
//			table[i] = table[i-1] + i;
//		}
//	}

}
