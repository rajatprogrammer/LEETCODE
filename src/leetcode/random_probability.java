package leetcode;

import java.util.Random;

//https://leetcode.com/problems/random-pick-with-weight/
public class random_probability {
	int bucketArr[];
	int maxRange=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		random_probability ob1 = new random_probability();
		int w[] = {1,3};
		ob1.Solution(w);
		System.out.println(ob1.pickIndex());
		System.out.println(ob1.pickIndex());
		System.out.println(ob1.pickIndex());
		System.out.println(ob1.pickIndex());
		System.out.println(ob1.pickIndex());
	}
	public void Solution(int w[]) {
		int len = w.length;
		bucketArr = new int[w.length];
		bucketArr[0]=w[0];
		for(int i=1;i<bucketArr.length;i++) {
			bucketArr[i] = bucketArr[i-1] + w[i];
		}
		maxRange = bucketArr[bucketArr.length-1];
	}
	
	public int pickIndex() {
        
       // Random random=new Random();
        int rand=(int) (Math.random() *(maxRange))+1;
        
        return binarySearch(rand);
    }
	 public int binarySearch(int key){
	        
	        int low=0;
	        int high=bucketArr.length-1;
	        
	        while(low<=high){
	            
	            int mid=low+(high-low)/2;
	            
	            if(bucketArr[mid]==key) return mid;
	            else
	            if(bucketArr[mid]<key) low=mid+1;
	            else
	            if(bucketArr[mid]>key) high=mid-1;
	        }
	        
	            return low;
	    }
	

}
