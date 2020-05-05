import java.util.ArrayList;
import java.util.List;


public class re_Construct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		re_Construct ob1  = new re_Construct(); 
		int a[] = {2,1,2,0,1,0,1,2,0,1};
		List<List<Integer>> ob2 =ob1.reconstructMatrix(5,5,a);
	}
	
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		 int a1[] = new int[colsum.length];
	        int a2[] = new int[colsum.length];
	        boolean test = false;
	        for(int i=0;i<colsum.length;i++){
	           if(colsum[i]==2){
	                if(upper>0 && lower>0){
	                    a1[i]=1;
	                    a2[i]=1;
	                --lower;
	                --upper;    
	                }else{
	                    test= true;
	                    break;
	                }   
	            } 
	        }
	        for(int i=0;i<colsum.length;i++){
	          //  System.out.println("at" + i + "lower" + lower + "highe" + upper);      
	             if(colsum[i]==1){
	                if(upper>0 ||  lower>0){     
	                 if(upper>0){
	                     a1[i]=1;
	                     a2[i]=0;
	                     --upper;
	                 }else if(lower>0){
	                     a1[i]=0;
	                     a2[i]=1;
	                     --lower;
	                 }
	                }else{
	                    test = true;
	                    break;
	                }
	                                 
	            }else if(colsum[i]==0){
	                a1[i]=0;
	                 a2[i]=0;
	            }
	        }
	        if(test){
	           return (new ArrayList<List<Integer>>());
	        }else{
	        	List<List<Integer>> ob1 = new ArrayList<List<Integer>>();
	        	List<Integer> low = new ArrayList<Integer>();
	        	List<Integer>  high = new ArrayList<Integer>();
	        	for(int i=0;i<colsum.length;i++) {
	        		System.out.print(a1[i] + "" + a2[i]);
	        	 	low.add(a1[i]);
	        	 	high.add(a2[i]);
	        	 	System.out.println();
	        	}
	        	ob1.add(low);
	        	ob1.add(high);
	            return ob1;
	        }
	    }

}
