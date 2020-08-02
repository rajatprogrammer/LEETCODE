package leetcode;
//https://leetcode.com/problems/task-scheduler/solution/
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class task_scheduler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int leastInterval(char[] tasks, int n) {
	        Map<Character,Integer> hs = new HashMap<Character,Integer>();
	        int arr[] = new int[26];
	        for(int i=0;i<tasks.length;i++){
	        	if(hs.containsKey(tasks[i])) {
	        		hs.put(tasks[i], hs.get(tasks[i])+1);
	        	}else {
	        		hs.put(tasks[i],1);
	        	}
	        }
	        PriorityQueue<Character> pq = new PriorityQueue<Character>(new Comparator<Character>() {
	        	public int compare(Character a,Character b) {
	        		return hs.get(b)- hs.get(a);
	        	}
	        });
	        
	        
	        return 0;
	    }
	  // worked solution
	  public int leastInterval1(char[] tasks, int n) {
	        int[] map = new int[26];
	        for (char c: tasks)
	            map[c - 'A']++;
	        Arrays.sort(map);
	        int max_val = map[25]-1,ideal = map[25]*n;
	        for(int i=24;i>-1;i--) {
	        	ideal = ideal-Math.min(max_val,map[i]);
	        }
	        return ideal==0?tasks.length:ideal+tasks.length;
	    }

}
