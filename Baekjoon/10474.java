import java.io.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		while(true){
			String tc[] = input.readLine().split(" ");
			int a = Integer.parseInt(tc[0]);
			int b = Integer.parseInt(tc[1]);
			
			if(a==0 && b==0){
				break;
			}
			
			int remain = a % b;
			int mok = a / b;
			
			output.append(mok+" "+remain+" / "+b+"\n");
		}
		
		System.out.println(output);
	}
}
