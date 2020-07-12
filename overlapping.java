package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class overlapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{1,2},{1,7}};
		System.out.print(eraseOverlapIntervals(intervals));
	}
	public static int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length == 0) return 0;
	    Arrays.sort(intervals, new Comparator<int[]>(){
	        public int compare(int[] a, int[] b){
	            return a[1]-b[1];
	        }
	    });
	    int end = intervals[0][1];
	    int count = 1;
	    for(int[] inter : intervals){
	        int start = inter[0];
	        if(start >= end){
	            count++;
	            end = inter[1];
	        }
	    }
	    return intervals.length-count;
	}

}
