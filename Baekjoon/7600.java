import java.io.*;
import java.util.Arrays;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		boolean use[] = new boolean[26];
		
		while(true){
			String aline = input.readLine().toUpperCase();
			int cnt = 0;
			
			if(aline.equals("#")){
				break;
			}
			
			for(int i=0; i<aline.length(); i++){
				char c = aline.charAt(i);
				if(Character.isAlphabetic(c) && !use[c-'A']){
					cnt++;
					use[c-'A'] = true;
				}
			}
			
			Arrays.fill(use, false);
			output.append(cnt).append("\n");
		}
		
		System.out.println(output);
	}
}
