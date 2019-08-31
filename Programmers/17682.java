import java.io.*;
import java.util.*;

public class 카카오2017_1_다트게임 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
				
		String tc = "1S2D*3T";
		
		int ans = solution(tc);
 		System.out.println(ans);
	}
	
	static public int solution(String dartResult) {
		Stack<Integer> stack = new Stack<>();
		int scores[] = new int[3];
		int idx = 0;
		boolean option = false;
		char op = ' ';
		
		char dart[] = dartResult.toCharArray();
		
		for(int i=0; i<dart.length; i++){
			char c = dart[i];
			option = false;
			
			if(!Character.isAlphabetic(c)){
				stack.push(c-'0');
				continue;
			}
			
			if(i+1 < dart.length && (dart[i+1] == '*' || dart[i+1] == '#')){
				option = true;
				op = dart[i+1];
				i++;
			}
			
			int score = 0;
			int digit = 1;
			
			while(!stack.isEmpty()){
				int n = stack.pop();
				
				score += (digit*n)+score;
				digit*=10;
			}
			
			switch(c){
			case 'S': score = (int)Math.pow(score, 1); break;
			case 'D': score = (int)Math.pow(score, 2); break;
			case 'T': score = (int)Math.pow(score, 3); break;
			}
			
			if(option){
				if(op == '*'){
					score *= 2;
					if(idx > 0){
						scores[idx-1] *= 2;
					}
				}
				else{
					score *= -1;
				}
			}
			
			scores[idx++] = score;
		}
		
		return scores[0]+scores[1]+scores[2];
	}
}

