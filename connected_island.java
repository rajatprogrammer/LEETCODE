import java.util.LinkedList;
import java.util.Queue;

public class connected_island {
		int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };  
		int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 }; 
		 static class pair 
		{  
		    int first, second;  
		    public pair(int first, int second)  
		    {  
		        this.first = first;  
		        this.second = second;  
		    }  
		}
		boolean isVisited[][];
		public int numIslands(char[][] grid) {
			int count=0;
			int R = grid.length;
			int C = grid[0].length;
			isVisited = new boolean[R][C];
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(!isVisited[i][j] && grid[i][j]=='1') {
						BFS(grid,i,j);
						 count++;
					}
				}
			}
			
			return count;
	        
	    }
		public void BFS(char[][] grid,int i,int j) {
			Queue<pair> q = new LinkedList<pair>();
			q.add(new pair(i,j));
			isVisited[i][j] = true;
			while(!q.isEmpty()) {
				int itr1 = q.peek().first;  
		        int itr2 = q.peek().second;  
		        q.remove();
				for(int i1=0;i1<8;i1++) {
					if(isSafe(grid, row[i1]+itr1, col[i1]+itr2)) {
						isVisited[row[i1]+itr1][col[i1]+itr2] = true;
						q.add(new pair(row[i1]+itr1, col[i1]+itr2));
					}
				}
			}
			
		}
		public boolean isSafe(char[][] grid,int i ,int j) {
			return ((i >= 0) && (i < grid.length) &&  
	        (j >= 0) && (j < grid[0].length) &&  
	        (grid[i][j]=='1' && !isVisited[i][j]));  
			
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub	
			connected_island ob1 =new connected_island();
			char grid[][]= { { '1', '1', '0', '0', '0' },  
                    { '0', '1', '0', '0', '1' },  
                    { '1', '0', '0', '1', '1' },  
                    { '0', '0', '0', '0', '0' },  
                    { '1', '0', '1', '0', '1' } };
			System.out.print(ob1.numIslands(grid));
		}
	

}
