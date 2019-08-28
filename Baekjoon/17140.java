import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	static final int SIZE = 100;
	static int map[][] = new int[SIZE][SIZE];
	static int r, c, k;
	
	static int rowLen=3, colLen=3;
	static HashMap<Integer, Integer> hm = new HashMap<>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String rck[] = input.readLine().split(" ");
		r = Integer.parseInt(rck[0])-1;
		c = Integer.parseInt(rck[1])-1;
		k = Integer.parseInt(rck[2]);
		
		for(int i=0; i<3; i++){
			String row[] = input.readLine().split(" ");
			for(int j=0; j<3; j++){
				map[i][j] = Integer.parseInt(row[j]);
			}
		}
		
		int time = 0;
		
		while(time <= 100){
			if(map[r][c] == k) break;
			
			time++;
			
			if(rowLen >= colLen){
				Rsort();
			}else{
				Ssort();
			}
		}
		
		System.out.println(time <= 100 ? time : -1);
	}

	private static void Ssort() {
		int maxLen = 0;
		
		for(int col=0; col<colLen; col++){
			hm.clear();
			for(int row=0; row<rowLen; row++){
				if(map[row][col] == 0) continue;
				
				hm.put(map[row][col], hm.getOrDefault(map[row][col], 0)+1);
				map[row][col] = 0;
			}	
			List<Entry<Integer, Integer>> sortedList = orderMap();
			int row = 0;
			
			for(int i=0; i<sortedList.size(); i++){
				if(col == SIZE/2) break;
				map[row][col] = sortedList.get(i).getKey();
				map[row+1][col] = sortedList.get(i).getValue();
				row+=2;
			}
			
			maxLen = Math.max(maxLen, row);
		}
		
		rowLen = maxLen;		
	}

	private static void Rsort() {
		int maxLen = 0;
		
		for(int row=0; row<rowLen; row++){
			hm.clear();
			for(int col=0; col<colLen; col++){
				if(map[row][col] == 0) continue;
				
				hm.put(map[row][col], hm.getOrDefault(map[row][col], 0)+1);
				map[row][col] = 0;
			}	
			List<Entry<Integer, Integer>> sortedList = orderMap();
			int col = 0;
			
			for(int i=0; i<sortedList.size(); i++){
				if(col == SIZE/2) break;
				map[row][col] = sortedList.get(i).getKey();
				map[row][col+1] = sortedList.get(i).getValue();
				col+=2;
			}
			
			maxLen = Math.max(maxLen, col);
		}
		
		colLen = maxLen;
	}

	private static List<Entry<Integer, Integer>> orderMap() {
		List<Entry<Integer, Integer>> list = new LinkedList<>(hm.entrySet());
		
		Collections.sort(list, new Comparator<Entry<Integer,Integer>>(){
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o1.getValue() == o2.getValue()){
					return o1.getKey() < o2.getKey() ? -1 : 1;
				}
				return o1.getValue() < o2.getValue() ? -1 : 1;
			}	
		});
		
		return list;
	}
}
