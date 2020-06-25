package leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/two-city-scheduling/
public class city_scheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{10,20},{30,200},{400,50},{30,20}};
		System.out.print(twoCitySchedCost(a));
	}
	
	public static int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(x, y)->{            
   	   return (x[0] - x[1]) - (y[0] - y[1]);
      });
       
      int i = 0, j = costs.length - 1;
      int sum = 0;
      while(i < j) {
   	   sum += costs[i][0] + costs[j][1];
          ++i;
          --j;
       }
       
      return sum;
   }
	

}
