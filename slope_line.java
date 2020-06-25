import java.util.Arrays;

//https://leetcode.com/problems/check-if-it-is-a-straight-line/

public class slope_line {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
		System.out.print(slope(arr));
	}
	public static  boolean slope(int arr[][]) {
		double[] slopes = new double[arr.length];
		Arrays.sort(arr,(x,y)->x[0]-y[0]);
		for(int i=1;i<arr.length;i++) {
			int x0 = arr[i-1][0];
			int y0 = arr[i-1][1];
			int x1 = arr[i][0];
			int y1 = arr[i][1];
			if(x1 != x0){
                slopes[i] = ((double)((y1-y0)/(x1-x0)));
            }
		}
		for(int i=1;i<slopes.length;i++) {
			if(i+1<slopes.length && slopes[i+1]!=slopes[i]) {
				return false;
			}
		}
		return true;
		
	}
}
