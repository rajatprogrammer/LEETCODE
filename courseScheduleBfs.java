package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//https://leetcode.com/problems/course-schedule-iv/
public class courseScheduleBfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule ob1 = new CourseSchedule();
		int prerequisites[][] = {{2,3},{2,1},{0,3},{0,1}};
		int queries[][] = {{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
		ob1.checkIfPrerequisite(4, prerequisites, queries);
	}
	
	private void bfs(int vertex,List<Integer> adjs[],int[][] matrix){
        Set<Integer> visited=new HashSet();
        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.offer(vertex);
        visited.add(vertex);
        while(!queue.isEmpty()){
            int v=queue.poll();
            if(adjs[v]!=null) {
                for(Integer adj:adjs[v]){
                    if(!visited.contains(adj)){
                        matrix[vertex][adj]=1;
                        queue.offer(adj);
                        visited.add(adj);
                    }    
                }
            }    
            
        }
        
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer> adjs[]=new List[n];
        for(int[] pr:prerequisites){
            if(adjs[pr[0]]==null)
               adjs[pr[0]]=new ArrayList<Integer>(); 
            adjs[pr[0]].add(pr[1]);
        }
        
        int[][] matrix=new int[n][n];       
        for(int i=0;i<n;i++){
            bfs(i,adjs,matrix);    
        }
        
        List<Boolean> res=new ArrayList();
        for(int[] q:queries){
            res.add(matrix[q[0]][q[1]]==1);
        }
        return res;
    }
}
