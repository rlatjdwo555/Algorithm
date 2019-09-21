import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		
		for(int i=0; i<8; i++){
			String nCase = input.readLine();
			
			for(int j = i % 2 == 0 ? 0 : 1; j<8; j+=2){
				count = nCase.charAt(j) == 'F' ? count + 1 : count;
			}
		}
		
		System.out.println(count);
	}
}
