import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class go_game_google {
	static int global=0;
	static Map<String,Boolean> ob2 = new HashMap<String,Boolean>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char mat[][] = {{'e','e','b','b','b','b','b'},
				        {'e','e','b','w','w','w','b'},
				        {'e','e','b','b','b','e','b'},
				        {'e','e','e','e','e','e','e'}};
		int Row =4,Col=7;
		mat[2][5]='b';
		List<List<Integer>> ob1 = new ArrayList<List<Integer>>();
		
		for(int i=0;i<Row;i++) {
			for(int j=0;j<Col;j++) {
				 if(mat[i][j]=='w') {
					List<Integer>t1=new ArrayList<Integer>();
					t1.add(i);
					t1.add(j);
					ob1.add(t1);
					ob2.put(i+","+j,false);
				}
			}
		}
		int total = 0;
		for(List<Integer> i1:ob1) {
			int i = (int) i1.get(0);
			int j = (int) i1.get(1);
			if(ob2.get(i+","+j)==false) {
				global=0;
				total=enemy_capture(mat,i,j);
			}
		}
		if(total==Integer.MAX_VALUE) {
			System.out.println("total enemy move" + 0);
		}else {
			System.out.println("total enemy move" + total);
		}
		
	}
	static int enemy_capture(char mat[][],int i,int j) {
		if(i<-1 || i>=4||j<-1 || j>=7) {
					return 0;	
		}
		
		else if(mat[i][j]=='e') {
			return Integer.MAX_VALUE;
		}else if(mat[i][j]=='b') {
			return 0;
		}
		else  {
			if(ob2.containsKey(i+","+j)) {
				if(ob2.get(i+","+j)==true) {
					return global;
				}else {
					ob2.put(i+","+j,true);
					global=global+1;
					int i1 = enemy_capture(mat, i-1, j);
					int i2 = enemy_capture(mat, i, j-1);
					int i3 = enemy_capture(mat, i+1, j);
					int i4 = enemy_capture(mat, i, j+1);
					if(i1==Integer.MAX_VALUE || i2==Integer.MAX_VALUE || i3==Integer.MAX_VALUE || i4==Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}else {
						return global;
					}
					
				}
			}
		}
		return global;
		
	}

}
