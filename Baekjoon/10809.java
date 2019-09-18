import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int alphabet[] = new int[26];
		
		Arrays.fill(alphabet, -1);
		
		String word = input.readLine();
		
		for(int i=0; i<word.length(); i++){
			int idx = word.charAt(i) - 'a';

			if(alphabet[idx] == -1){
				alphabet[idx] = i;
			}
		}
		
		StringBuilder output = new StringBuilder();
		
		for(int n : alphabet){
			output.append(n+" ");
		}
		
		System.out.println(output);
	}
}
