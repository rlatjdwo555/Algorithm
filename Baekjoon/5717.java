import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		while(true){
			String tc[] = input.readLine().split(" ");
			if(tc[0].equals("0") && tc[1].equals("0")){
				break;
			}
			output.append(Integer.parseInt(tc[0])+Integer.parseInt(tc[1])).append("\n");
		}
		
		System.out.println(output);
	}
}
