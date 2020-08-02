package leetcode;

import java.util.Arrays;
import java.util.Collections;
//https://leetcode.com/problems/the-k-strongest-values-in-an-array/
public class K_strongest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,2,3,4,5};
		getStrongest(arr,2);
	}
	//Two pointer approach 
	public static int[] getStrongest(int[] arr, int L) {
		Integer ob1[] = new Integer[arr.length];
		for(int i=0;i<arr.length;i++) {
			ob1[i] = arr[i];	
		}
        Arrays.sort(ob1,(a,b)->b-a);
        int med = 0;
        int n = ob1.length;
        if(n%2==0){
          med = n/2; 
        }else{
        med = ((n-1)/2);    
        }
        med = ob1[med];
        int ou[] = new int[L];
        int count=0;
        boolean flag = false;
        int p1=0;
        int p2 = arr.length-1;
        while(p1<=p2 && count<L) {
        	if(Math.abs(ob1[p1]-med)<Math.abs(ob1[p2]-med)) {
        		ou[count]=ob1[p2];
        		p2--;
        	}else if(Math.abs(ob1[p1]-med)>Math.abs(ob1[p2]-med)) {
        		ou[count]=ob1[p1];
        		p1++;	
        	}else if(Math.abs(ob1[p1]-med)==Math.abs(ob1[p2]-med)) {
        			ou[count]=ob1[p1];
        			p1++;
        	}
        	count++;
        }
        return ou;
        
    }
	public static int[] TwoPointergetStrongest(int[] arr, int k) {
		        int n = arr.length;
		        Arrays.sort(arr);
		        int mid = (n - 1) / 2;
		        int left = 0, right = n - 1, count = 0;
		        int[] ans = new int[k];
		        int it = 0;
		        while(count < k && left <= right) {
		            count++;
		            int x = Math.abs(arr[mid] - arr[left]), y = Math.abs(arr[mid] - arr[right]);
		            if(x > y) ans[it++] = arr[left++];
		            else ans[it++] = arr[right--];
		        }
		        return ans;
		    }
}
