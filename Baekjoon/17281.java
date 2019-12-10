import java.io.*;
import java.util.*;

public class Main {
	
	static int N = 9, M = 4, ans = 0;
	static boolean use[] = new boolean[N];
	static int players[] = new int[N];
	static int results[][];
	
	static HashMap<Integer, HashMap<Integer, int[]>> field = new HashMap<>();
	static{
		field.put(0, new HashMap<>());
		field.get(0).put(1, new int[]{1,0});
		field.get(0).put(2, new int[]{2,0});
		field.get(0).put(3, new int[]{3,0});
		field.get(0).put(4, new int[]{0,1});
		
		field.put(1, new HashMap<>());
		field.get(1).put(1, new int[]{12,0});
		field.get(1).put(2, new int[]{23,0});
		field.get(1).put(3, new int[]{3,1});
		field.get(1).put(4, new int[]{0,2});
		
		field.put(2, new HashMap<>());
		field.get(2).put(1, new int[]{13,0});
		field.get(2).put(2, new int[]{2,1});
		field.get(2).put(3, new int[]{3,1});
		field.get(2).put(4, new int[]{0,2});
		
		field.put(3, new HashMap<>());
		field.get(3).put(1, new int[]{1,1});
		field.get(3).put(2, new int[]{2,1});
		field.get(3).put(3, new int[]{3,1});
		field.get(3).put(4, new int[]{0,2});
		
		field.put(12, new HashMap<>());
		field.get(12).put(1, new int[]{123,0});
		field.get(12).put(2, new int[]{23,1});
		field.get(12).put(3, new int[]{3,2});
		field.get(12).put(4, new int[]{0,3});
		
		field.put(13, new HashMap<>());
		field.get(13).put(1, new int[]{12,1});
		field.get(13).put(2, new int[]{23,1});
		field.get(13).put(3, new int[]{3,2});
		field.get(13).put(4, new int[]{0,3});
		
		field.put(23, new HashMap<>());
		field.get(23).put(1, new int[]{13,1});
		field.get(23).put(2, new int[]{2,2});
		field.get(23).put(3, new int[]{3,2});
		field.get(23).put(4, new int[]{0,3});
		
		field.put(123, new HashMap<>());
		field.get(123).put(1, new int[]{123,1});
		field.get(123).put(2, new int[]{23,2});
		field.get(123).put(3, new int[]{3,3});
		field.get(123).put(4, new int[]{0,4});
	}
	
    public static void main(String args[]) throws Exception{
    	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	
    	int inning = Integer.parseInt(input.readLine());
    	results = new int[inning][N];
    	
    	for(int i=0; i<inning; i++){
    		String tc[] = input.readLine().split(" ");
    		for(int j=0; j<N; j++){
    			results[i][j] = Integer.parseInt(tc[j]);
    		}
    	}
    	
    	getOrder(0, inning);
    	System.out.println(ans);
    }

	static int getScore(int[] order, int range) {
		int score = 0;
		int out = 0;
		int cur = -1;
		int state = 0;
		int inning = 0;
		
		while(inning < range){
			cur++;
			int result = results[inning][order[cur%N]];
			
			if(result > 0){
				int rs[] = field.get(state).get(result);
				state = rs[0];
				score+=rs[1];
				continue;
			}
			
			out++;
			
			if(out == 3){
				inning++;
				out = 0;
				state = 0;
			}
		}
		
		return score;
	}

	static void getOrder(int idx, int inning) {
		if(players[3] != 0 && use[0]){
			return;
		}
		
		if(idx == N){
			ans = Math.max(ans, getScore(players, inning));
			return;
		}
		
		for(int i=0; i<N; i++){
			if(!use[i]){
				use[i] = true;
				players[idx] = i;
				getOrder(idx+1, inning);
				use[i] = false;
			}
		}
	}
}
