

//https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
//https://leetcode.com/problems/word-search/
public class word_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		word_Search ob1 = new word_Search();
		char board[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ob1.exist(board,"SEE"));
		System.out.println(ob1.exist(board,"ABCCED"));
		System.out.println(ob1.exist(board,"ABCB"));
	}
	public boolean exist(char[][] board, String word) {
        char [] wordArray = word.toCharArray();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(wordArray[0] == board[i][j] && search(board, wordArray, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, char [] wordArray, int i, int j, int index){
        if(index >= wordArray.length){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != wordArray[index]){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        boolean wordFound = (search(board, wordArray, i-1, j, index+1) || search(board, wordArray, i+1, j, index+1) || search(board, wordArray, i, j-1, index+1) || search(board, wordArray, i, j+1, index+1));
        
        board[i][j] = temp;
        
        return wordFound;
    }

}