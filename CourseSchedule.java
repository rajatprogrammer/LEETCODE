package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
//https://leetcode.com/problems/course-schedule-iv/
public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule ob1 = new CourseSchedule();
		int prerequisites[][] = {{2,3},{2,1},{0,3},{0,1}};
		int queries[][] = {{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
		ob1.checkIfPrerequisite(4, prerequisites, queries);

	}
	 public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
		 List<Boolean> out = new ArrayList<Boolean>();
	        if(prerequisites.length==0){
	            for(int k=0;k<queries.length;k++) {
				    out.add(false);
	            }
	            return out;
	        }
		 List<Integer>adj[] = new ArrayList[n];
		 for(int i=0;i<n;i++) {
			 adj[i] = new ArrayList<Integer>();
		 }
		 for(int k=0;k<prerequisites.length;k++) {
			 adj[prerequisites[k][0]].add(prerequisites[k][1]);
		 }
		 Map<Integer, List<Integer>> topo = topologicalSort(adj,n);
		 for(int k=0;k<queries.length;k++) {
			if(topo.get(queries[k][1]).contains(queries[k][0])) {
				out.add(true);
			}else {
				out.add(false);
			}
		 }
		 return out;
	        
	    }
	public Map<Integer, List<Integer>> topologicalSort(List<Integer>adj[],int n) {
		boolean visited[] = new boolean[n];
		Stack<Integer> s1 = new Stack<Integer>();
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				topologicalSortUtil(adj,s1,visited,i);	
			}
		}
		int arr = s1.size();
		Map<Integer, List<Integer>> hs = new HashMap<Integer, List<Integer>>();
		List<Integer>temp = new ArrayList<Integer>();
		while(s1.size()>0) {			
			int data = s1.pop();
			System.out.print(data + "->");
			temp.add(data);
			List<Integer>temp2 = new ArrayList<Integer>(); 
			temp2.addAll(temp);
			hs.put(data, temp2);
		}
		return hs; 
		
	}
	public void topologicalSortUtil(List<Integer>adj[],Stack<Integer> s1,boolean visited[],int dest) {
		visited[dest]= true;	
		Iterator<Integer> itr = adj[dest].iterator();
		while(itr.hasNext()) {
			Integer elem = itr.next();
			if(visited[elem]==false) {
				topologicalSortUtil(adj,s1,visited,elem);	
			}
		}
		s1.push(dest);
	}
	
	
	

}
