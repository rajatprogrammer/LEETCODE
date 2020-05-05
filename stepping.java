import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class stepping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stones[] = {2,2,4,1};
		int x=lastStoneWeight(stones);
		System.out.print(x);
	}
	public static  int lastStoneWeight(int[] stones) {
        if(stones.length<1){
            return 0;
        }
        Queue<Integer>q = new PriorityQueue<Integer>(stones.length,Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            q.add(stones[i]);
        }
        while(q.size()>=2){
            q.add((q.remove()-q.remove()));
        }
        
        if(q.isEmpty()) {
        	return 0;
        }else {
        	return q.remove();
        }
            
    }


}
