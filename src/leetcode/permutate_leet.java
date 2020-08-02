package leetcode;

public class permutate_leet {
	int count=1;
    String data ="";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String getPermutation(int n, int k) {
        String str="";
        for(int i=1;i<=n;i++){
            str = str + i;
        }
         permutate(str,0,str.length()-1,k);
        return data;
    }
    
    public String swap (String a,int i,int j) {
		char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
		
	}
    
    public void permutate(String str,int s,int e,int k) {
		if(s==e) {
            count++;
            if(k==count){
                data=str;
            }	
		}else {
			for(int i=s;i<e;i++) {
				str = swap(str,s,i);
				permutate(str, s+1, e,k);
				str = swap(str,s,i);
			}
		}
	}

}
