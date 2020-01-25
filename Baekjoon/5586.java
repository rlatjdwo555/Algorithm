import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int joi = 0;
		int ioi = 0;
		
		char inputText[] = br.readLine().toCharArray();
		int len = inputText.length;
		
		for(int i=2; i<len; i++){
			char word1 = inputText[i-2];
			char word2 = inputText[i-1];
			char word3 = inputText[i];
			
			if(word1 == 'J' && word2 =='O' && word3 == 'I'){
				joi++;
			}
			else if(word1 == 'I' && word2 =='O' && word3 == 'I'){
				ioi++;
			}
		}
		
		System.out.println(joi+"\n"+ioi);
	}
}
