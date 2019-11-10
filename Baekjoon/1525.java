import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int X[] = {0,0,-1,1};
	static int Y[] = {-1,1,0,0};

	
	public static void main(String args[]) throws Exception {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int start = 0;
		
		for(int i=0; i<3; i++){
			String rows[] = input.readLine().split(" ");
			for(int j=0; j<3; j++){
				int value = Integer.parseInt(rows[j]);
				if(value == 0) value = 9;
				start = start*10 + value;
			}
		}
		
		BFS(start);
		if(map.containsKey(123456789)){
			output.append(map.get(123456789)+"\n");
		}else{
			output.append("-1\n");
		}
		System.out.println(output);
	}
	
	static void BFS(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		map.put(start, 0);
		
		while(!queue.isEmpty()){
			int cur = queue.poll();
			String num = String.valueOf(cur);
			
			int blank = num.indexOf('9');
			int x = blank/3;
			int y = blank%3;
			
			for(int i=0; i<4; i++){
				int nx = x+X[i];
				int ny = y+Y[i];
				
				if(nx>-1 && nx<3 && ny>-1 && ny<3){
					StringBuilder next = new StringBuilder(num);
					char temp = next.charAt(x*3+y);
					
					next.setCharAt(x*3+y, (char)next.charAt(nx*3+ny));
					next.setCharAt(nx*3+ny, temp);
					
					int newNum = Integer.parseInt(next.toString());
					
					if(!map.containsKey(newNum)){
						map.put(newNum, map.get(cur)+1);
						queue.offer(newNum);
					}
				}
			}
		}
	}
}
