import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	static HashSet<Character> censorship;
	
	static{
		censorship = new HashSet<Character>();
		
		censorship.add('C');
		censorship.add('A');
		censorship.add('M');
		censorship.add('B');
		censorship.add('R');
		censorship.add('I');
		censorship.add('D');
		censorship.add('G');
		censorship.add('E');
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char inputText[] = br.readLine().toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(char word : inputText){
			if(!censorship.contains(word)){
				sb.append(word);
			}
		}
		
		System.out.println(sb);
	}
}
