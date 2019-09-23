import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Character> stack = new Stack<>();
		
		while(true) {
			String aline = input.readLine();
			
			if(aline.equals(".")) break;
			
			char line[] = aline.toCharArray();
			boolean right = true;
			
			for(int i=0; i<line.length; i++) {
				char c = line[i];
				
				if(c == '(' || c == '[') stack.add(c);
				else if(c == ')') {
					if(stack.isEmpty() || stack.peek() != '(') {
						right = false;
						break;
					}
					stack.pop();
				}else if(c == ']') {
					if(stack.isEmpty() || stack.peek() != '[') {
						right = false;
						break;
					}
					stack.pop();
				}
			}
			
			if(!stack.empty()) right = false;
			
			output.write(right ? "yes\n" : "no\n");
			stack.clear();
		}
		
		output.flush();
	}
}
