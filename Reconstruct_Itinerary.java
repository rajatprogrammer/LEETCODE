package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// https://leetcode.com/problems/reconstruct-itinerary/
public class Reconstruct_Itinerary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reconstruct_Itinerary ob1 = new Reconstruct_Itinerary();
		List<List<String>> ob2 = new ArrayList<List<String>>();
		String[][] ob3 ={{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		ob2.add(Arrays.asList(ob3[0]));
		ob2.add(Arrays.asList(ob3[1]));
		ob2.add(Arrays.asList(ob3[2]));
		ob2.add(Arrays.asList(ob3[3]));
		ob2.add(Arrays.asList(ob3[4]));
		List<String> res=ob1.findItinerary(ob2);
		for (String string : res) {
			System.out.print(string + "-");
		}
		
	}
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> mp = new HashMap<String, PriorityQueue<String>>();
		Iterator<List<String>>itr = tickets.iterator();
		while(itr.hasNext()) {
			List<String> temp = itr.next();
			mp.putIfAbsent(temp.get(0),new PriorityQueue<String>());
			mp.get(temp.get(0)).add(temp.get(1));
		}
		List<String> res = new ArrayList<String>();
		iterateAirport(mp,"JFK",res);
		
		return res;
    }
	
	public void iterateAirport(Map<String, PriorityQueue<String>>mp,String dest,List<String>res) {
		PriorityQueue<String> pq = mp.get(dest);
		while(pq!=null && !pq.isEmpty()) {
			iterateAirport(mp, pq.poll(), res);
		}
		res.add(0,dest);
	}
	

}
