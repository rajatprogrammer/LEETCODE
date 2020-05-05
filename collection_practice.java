import java.util.*;
public class collection_practice {
	int start;
	int end;
	public collection_practice(int start,int end) {
		// TODO Auto-generated constructor stub
		this.start = start;
		this.end = end;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collection_practice ob1[] = new collection_practice[4];
		ob1[0] = new collection_practice(1,3);
		ob1[1] = new collection_practice(6,8);
		ob1[2] = new collection_practice(5,7);
		ob1[3]=new collection_practice(2,4);
//		Arrays.sort(ob1,new Comparator<collection_practice>() {
//			@Override
//			public int compare(collection_practice arg0, collection_practice arg1) {
//				// TODO Auto-generated method stub
//				return (arg0.start-arg1.start);
//			}
//	});
		 Arrays.sort(ob1,(a1,a2)->a1.start-a2.start);
		for(collection_practice itr:ob1) {
			System.out.println(itr.start  + "," + itr.end);
		}
	}

}
