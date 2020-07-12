package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//https://leetcode.com/problems/car-pooling/
public class car_plooing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		car_plooing ob1= new car_plooing();
		int trips[][] = {{3,2,7},{3,7,9},{8,3,9}};
		System.out.print(ob1.carPooling(trips, 11));
	}
	
	 public boolean carPooling(int[][] trips, int capacity) {
		 if(trips==null || trips.length==0)
	            return true;
	        Arrays.sort(trips, new Comparator<int[]>(){
	            public int compare(int[]t1, int[] t2){
	                return t1[1]-t2[1];
	            }
	        });
	        
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
	            public int compare(int[]t1, int[] t2){
	                return t1[2]-t2[2];
	            }
	        });
	        
	        for(int[] trip: trips){
	            while(!pq.isEmpty() && pq.peek()[2]<=trip[1]){
	                capacity +=pq.poll()[0];
	            }
	            if(capacity<trip[0]){
	                return false;
	            }
	            pq.offer(trip);
	            capacity-=trip[0];
	        }
	        return true;
     }

}
