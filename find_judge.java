import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class find_judge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
		int [][] trust = {{1,8},{1,3},{2,8},{2,3},{4,8},{4,3},{5,8},{5,3},{6,8},{6,3},{7,8},{7,3},{9,8},{9,3},{11,8},{11,3}};
		System.out.println(findJudge(11,trust));
	}
	 public static  int findJudge(int N, int[][] trust) {
		 if(trust.length<1) {
			 return N;
		 }
		 Map<Integer,Map<Integer, Boolean>> ob1 = new HashMap<Integer, Map<Integer,Boolean>>();
		 Map<Integer,Integer> inTrust = new HashMap<Integer, Integer>();
		 List<Integer> allTrust = new ArrayList<Integer>();
		 for(int i=0;i<trust.length;i++) {
			 if(ob1.containsKey(trust[i][0])){
				 Map<Integer, Boolean> temp1 = ob1.get(trust[i][0]);
				 temp1.put(trust[i][1],true);
				 if(!inTrust.containsKey(trust[i][1])) {
					 inTrust.put(trust[i][1],1);
				 }else {
					 inTrust.put(trust[i][1], (inTrust.get(trust[i][1])+1)); 
				 }
				 if(inTrust.get(trust[i][1])==N-1) {
					 allTrust.add(trust[i][1]);
				 }
				 ob1.put(trust[i][0],temp1);
			 }else {
				 Map<Integer, Boolean> temp = new HashMap<Integer, Boolean>();
				 temp.put(trust[i][1],true);
				 if(!inTrust.containsKey(trust[i][1])) {
					 inTrust.put(trust[i][1],1);
				 }else {
					 inTrust.put(trust[i][1], (inTrust.get(trust[i][1])+1)); 
				 }
				 if(inTrust.get(trust[i][1])==N-1) {
					 allTrust.add(trust[i][1]);
				 }
				 ob1.put(trust[i][0],temp); 
			 }
		 }
		 	int judge = -1;
		 	for(Integer da:allTrust) {
		 		for(int i=1;i<=N;i++) {
		 			if(ob1.containsKey(da)) {
		 				continue;
		 			}else {
		 				judge=da;
		 			}
		 		}
		 	}
	        return judge;
	        
	    }

}
