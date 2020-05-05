
public class count_say {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =6;
		String s="11";
		for(int i=2;i<n;i++) {
			int count =1;
			String t_count="";
			for(int j=1;j<=s.length();j++) {
				if(j==s.length()) {
					t_count = t_count + count + s.charAt(j-1);
					continue;
				}
				if(s.charAt(j-1)==s.charAt(j)) {
					count ++ ;
				}
				else {
					t_count = t_count + count + s.charAt(j-1);
					count=1;
				}
			}
			if(t_count=="") {
				s= ""+count+s.charAt(s.length()-1);
			}else {
				s= t_count;
			}
		}
		System.out.print(s);
	}

}
