package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/queue-reconstruction-by-height/
public class reconstructQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}; 
		reconstructQueue(arr);
	}
	
	public static int[][] reconstructQueue(int[][] people) {
        if(people.length>0) {
        	Arrays.sort(people,(a,b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        	List<int[]> ob1 = new ArrayList<int[]>();
        	for(int i=0;i<people.length;i++) {
        		ob1.add(people[i][1],people[i]);
        	}
        	int output[][] = new int[people.length][2];
        	int count =0;
        	for (int[] temp : ob1) {
        		output[count][0] = temp[0];
        	    output[count][1] = temp[1];
        	    count++;
			}
        	return output;
        }else {
        	return new int[0][0];
        }
    }

}
