package leetcode;

public class permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		permutation ob1 = new permutation();
		ob1.permutate("ABC",0,3);
	}
	public void permutate(String str,int s,int e) {
		if(s==e) {
			System.out.println(str);
		}else {
			for(int i=s;i<e;i++) {
				str = swap(str,s,i);
				permutate(str, s+1, e);
				str = swap(str,s,i);
			}
		}
	}
	
	public String swap (String a,int i,int j) {
		char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
		
	}
	
	

}
