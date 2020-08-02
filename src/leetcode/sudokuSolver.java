package leetcode;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/valid-sudoku/
public class sudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][]= {{'5','3','.','.','7','.','.','.','.'},
	             {'6','.','.','1','9','5','.','.','.'},
	             {'.','9','8','.','.','.','.','6','.'},
	             {'8','.','.','.','6','.','.','.','3'},
	             {'4','.','.','8','.','3','.','.','1'},
	             {'7','.','.','.','2','.','.','.','6'},
	             {'.','6','.','.','.','.','2','8','.'},
	             {'.','.','.','4','1','9','.','.','5'},
	             {'.','.','.','.','8','.','.','7','9'}};
		System.out.print(isValidSudoku(board));	
	}
	public static boolean isValidSudoku(char[][] board) {
	     	Set<Character> row=new HashSet();
	        Set<Character> col=new HashSet();
	        Set<Character> board3[]=new HashSet[9];
	        for(int i=0;i<9;i++)  board3[i]=new HashSet();
	      
	        //row && column && board 3*3
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                if(!row.contains(board[i][j])&&board[i][j]!='.')  row.add(board[i][j]);
	                else if(row.contains(board[i][j])) return false;
	                
	                if(!col.contains(board[j][i])&&board[j][i]!='.')  col.add(board[j][i]);
	                else if(col.contains(board[j][i])) return false;
	                
	                int b=(i/3)*3+ (j/3);
	                if(!board3[b].contains(board[i][j])&&board[i][j]!='.') board3[b].add(board[i][j]);
	                else if(board3[b].contains(board[i][j])) return false;
	                                               }
	            row=new HashSet();
	            col=new HashSet();
	        }
	        return true;      
	    }
}
