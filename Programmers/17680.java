import java.io.*;
import java.util.*;

public class 카카오2017_1_캐시 {
	
	static final int HIT = 1;
	static final int MISS = 5;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String arr1[] = {"Jeju", "pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		int ans = solution(0, arr1);
 		System.out.println(ans);
	}
	
	static public int solution(int cacheSize, String[] cities) {
		LinkedList<String> queue = new LinkedList<>();
		int pay = 0;
		
		if(cacheSize == 0){
			return MISS*cities.length;
		}
		
		for(String s : cities){
			String city = s.toLowerCase();
						
			int targetIndex = queue.indexOf(city);
			
			if(targetIndex > -1){
				queue.addFirst(queue.remove(targetIndex));
				pay += HIT;
			}else{
				if(queue.size() >= cacheSize){
					queue.pollLast();
				}
				queue.addFirst(city);
				pay += MISS;
			}
		}
		
		return pay;
	}
}

