package leetcode;
//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class tokK {
	class store{
        int data;
        int count;
        public store(int data,int count){
            this.data=data;
            this.count=count;
        }
        public void increaseCount(){
            count=count+1;
        }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] topKFrequent(int[] nums, int k) {
        int result[] = new int[k];
       Map<Integer,store> hs = new HashMap<Integer,store>();
       for(int i=0;i<nums.length;i++){
           if(hs.containsKey(nums[i])){
                store temp= hs.get(nums[i]);
                temp.increaseCount();
                hs.put(nums[i],temp);
           }else{
               store temp=new store(nums[i],1);
               hs.put(nums[i],temp);
           }
       }
        PriorityQueue<store> pq = new PriorityQueue<store>(new Comparator<store>() {

			@Override
			public int compare(store o1, store o2) {
				return o2.count-o1.count;
			}
        	
		});
        for (Map.Entry<Integer,store> entry : hs.entrySet()){
            pq.add(entry.getValue());
        }
        int count=0;
        while(!pq.isEmpty() && k>0){
            result[count] = pq.poll().data;
            count++;
            k--;
        }
        return result;
    }

}
