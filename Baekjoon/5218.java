import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String []args) throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int nCase = Integer.parseInt(input.readLine());
		StringBuilder output = new StringBuilder();
		
		while(nCase-- > 0){
			String testCase[] = input.readLine().split(" ");
            output.append("Distances: ");
			
			for(int i=0; i<testCase[0].length(); i++){
				int d = (26 + (testCase[1].charAt(i) - testCase[0].charAt(i))) % 26;
				output.append(d+" ");
			}
			
			output.append("\n");
		}
		
		System.out.println(output);
	}
}
