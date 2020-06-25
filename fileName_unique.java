package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/making-file-names-unique/
public class fileName_unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fileName_unique ob1 =new fileName_unique();
		String[] ob2= {"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece","onepiece"};
		ob1.getFolderNames(ob2);
	}
	 public String[] getFolderNames(String[] names) {
		 HashMap<String,Integer[]> ob1 = new HashMap<String,Integer[]>();
		 String res [] = new String[names.length];
		 for(int i=0;i<names.length;i++) {
			 String temp = names[i];
			 int index =names[i].indexOf('(');
			 if(index!=-1) {
				 String sub = temp.substring(0,index);
				 if(ob1.containsKey(sub)) {
					 Integer tes[] = ob1.get(sub);
					 int x = Integer.parseInt(names[i].substring(index+1,names[i].indexOf(')')));
					 tes[0] = tes[0]+x ;
					 tes[1]=tes[1]+1;
					 ob1.put(sub,tes);
				 }else {
					 Integer arr[] = new Integer[2];
					 arr[0]=Integer.parseInt(names[i].substring(index+1,names[i].indexOf(')')));
					 arr[1]=1;
					 ob1.put(sub,arr);
				 }
			 }else {
				 if(ob1.containsKey(names[i])) {
					 Integer tes[] = ob1.get(names[i]); 
					 int n= tes[1]+1;
					 int val = (n*(n+1))/2;
					 val = val-tes[0];
					 names[i]=names[i]+'('+val+')';
					 tes[0]=tes[0]+val;
					 tes[1]=n;
					 ob1.put(names[i],tes);
					 
				 }else {
					 Integer arr[] = new Integer[2]; 
					 arr[0]=0;
					 arr[1]=0;
					 ob1.put(names[i],arr);
				 }
			 }
			 res[i]=names[i];
		 }
		 return res;
	 }
	 public String[] getFolderNames2(String[] names) {
		 HashMap<String,Integer> ob1 = new HashMap<>(); 
		 String res [] = new String[names.length];
	        for(int i=0;i<names.length;i++){
	            if(ob1.containsKey(names[i])){
	                int count = ob1.get(names[i])+1;
	                String temp = names[i]+"("+count+")";
	                if(ob1.containsKey(temp)){
	                   count = count+1;    
	                }
	                ob1.put(names[i],count);
	                res[i] = names[i]+"("+count + ")";
	                
	            }else{
	                res[i]=names[i];
	                 ob1.put(names[i],0);
	            }
	        }
	        return res;
	 
	 }
	 
	 public String[] getFolderNames3(String[] names) {

		    Map<String, Integer> map = new HashMap<>();        
		    for (int i=0; i < names.length; i++){
		        names[i] = getName(map, names[i]);
		    }
		    return names;
		}

		private String getName(Map<String, Integer> map, String name){
		    if (map.containsKey(name)){                
		        int n = map.get(name) + 1;
		        
		        while (map.containsKey(name + "(" + n + ")")){
		            n++;
		        }
		        map.put(name, n);    
		        name = getName(map, name + "(" + n + ")");
		        
		        
		    } else {
		        map.put(name, 0);
		    }
		    return name;
		}

}
