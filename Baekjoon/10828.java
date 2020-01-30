import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test_case; i++){
			String command = br.readLine();
			
			if(command.startsWith("push")){
				stack.push(Integer.parseInt(command.substring(5)));
			}
			else if(command.equals("pop")){
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.pop()+"\n");
			}
			else if(command.equals("size")){
				sb.append(stack.size()+"\n");
			}
			else if(command.equals("empty")){
				if(stack.isEmpty()) sb.append("1\n");
				else sb.append("0\n");
			}
			else{
				if(stack.isEmpty()) sb.append("-1\n");
				else sb.append(stack.peek()+"\n");
			}
		}
		System.out.println(new String(sb));
	}
}