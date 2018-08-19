import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

	
class Baekjoon {
	
	/**
	 * @문제 : 달팽이는 올라가고 싶다　　　　　　　　	　				　		                                            
	 * @날짜 : 18.04.26
	 * @풀이 : 첫 날 제외 남은 길이 L : V-A, 하루 이동 거리 M : A-B 이므로  
	 * 첫 날 제외 총 필요한 날은 L / M 이다. 
	 */
	void Q2869() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] command = input.readLine().split(" ");
		
		int A = Integer.parseInt(command[0]);
		int B = Integer.parseInt(command[1]);
		int V = Integer.parseInt(command[2]);
		
		int length = V-A;
		int move = A-B;
		int result = length % move != 0 ? length/move+1 : length/move; 
		
		System.out.println(result+1);
	}
	
	
	/**
	 * @문제 : 숫자 카드　　　　　　　　	　				　		                                            
	 * @날짜 : 18.04.26
	 * @풀이 : HashSet으로 비교할 숫자 집합을 입력하고 비교값을 키와 비교(contanis)
	 * syso로 계속 찍어내는 것이 아니라 StringBuilder 사용하여 속도 단축
	 */
	void Q10815() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> have = new HashSet<>();
		
		input.readLine();
		
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		while(token.hasMoreTokens()){
			have.add(Integer.parseInt(token.nextToken()));
		}
		
		input.readLine();
		
		token = new StringTokenizer(input.readLine());
		StringBuilder output = new StringBuilder();
		
		while(token.hasMoreTokens()){
			if(have.contains(Integer.parseInt(token.nextToken()))){
				output.append("1 ");
			}else{
				output.append("0 ");
			}
		}
		
		System.out.println(output);
	}
	
	
	/**
	 * @문제 : 카이사르 암호
	 * @날짜 : 18.04.26
	 * @풀이 : 삼항연산자와 문자열 수식 계산, String 고정형이 아니라 문자열 배열이기 때문에
	 * 값을 변경할 수 있다. 배열을 String 시키는 방법도 toString 뿐만이 아니라 new String() 
	 */
	void Q5598() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char word[] = br.readLine().toCharArray();
		
		for(int idx=0; idx<word.length; idx++){
			word[idx]+=word[idx]-3 < 'A' ? 23 : -3;
		}
		
		System.out.println(new String(word));
	}
	
	
	/**
	 * @문제 : 단어의 개수
	 * @날짜 : 18.04.28
	 * @풀이 : BufferedReader, StringTokenizer 사용법 복습 
	 */
	void Q1152() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		while(st.hasMoreTokens()){
			st.nextToken();
			count++;
		}
		
		System.out.println(count);
	}
	
	
	/**
	 * @문제 : 알파벳 찾기
	 * @날짜 : 18.04.28
	 * @풀이 : 알파벳은 26자다!! 꼭좀 기억하자.. Arrays.fill 함수 사용해서 초기화
	 */
	void Q10809() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		
		char str[] = br.readLine().toCharArray();
		
		for(int i=0; i<str.length; i++){
			int idx = 25 - ('z'-str[i]);
			if(arr[idx] == -1){
				arr[idx] = i;
			}
		}
		
		for(int c : arr){
			System.out.printf("%d ",c);
		}
	}
	
	
	/**
	 * @문제 : 알파벳 거리
	 * @날짜 : 18.04.28
	 * @풀이 : charAt 이랑 배열로 바꿔서 읽는거랑 속도면에서 거의 차이가 없다.. 
	 * 단 BufferedReader와 Scanner는 데이터 양이 많을수록 확실히 속도 차이가 난다.
	 * 배열이 한 개 이상일 경우에는 charAt 쓰는 것도 고려해보자.
	 */
	void Q5218() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCount = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < testCount; i++) {
			String testCase[] = br.readLine().split(" ");

			int strLength = testCase[0].length();
			sb.append("Distances: ");

			for (int j = 0; j < strLength; j++) {
				int distance = (26 + (testCase[1].charAt(j) - testCase[0].charAt(j))) % 26;
				sb.append(distance + " ");
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}
	
	/**
	 * @문제 : 스택
	 * @날짜 : 18.04.29
	 * @풀이 : util에서 제공하는 stack함수로 구현 
	 * syso 많이 찍는 것보다 stringBuilder로 한번에 하는게 더 빠르다 
	 * stack이 비었을 때 pop과 top을 호출하면 예외가 발생한다!
	 */
	void Q10828() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int nCase = Integer.parseInt(input.readLine());
		StringBuilder output = new StringBuilder();
		
		while(nCase-- > 0){
			String command = input.readLine();
			
			if(command.startsWith("push")){
				stack.push(Integer.parseInt(command.substring(5)));
			}
			else if(command.startsWith("top")){
				if(stack.isEmpty()) output.append("-1\n");
				else output.append(stack.peek()+"\n");
			}
			else if(command.startsWith("size")){
				output.append(stack.size()+"\n");
			}
			else if(command.startsWith("empty")){
				if(stack.isEmpty()) output.append("1\n");
				else output.append("0\n");
			}
			else if(command.startsWith("pop")){
				if(stack.isEmpty()) output.append("-1\n");
				else output.append(stack.pop()+"\n");			
			}
		}
		
		System.out.println(output);
	}
	
	
	/**
	 * @문제 : 2017 NTS 동계인턴 코딩테스트 5번문제 
	 * @날짜 : 18.04.29
	 * @풀이 : stack을 이용하여 풀이, char 숫자를 int로 변환할 때 -48 or -'0' 후자가 더 직관적.
	 * 반복문 돌 때 조건문도 매번 시행이 되기 때문에 조건 횟수 정의는 따로 할 것!! 
	 * @수정 : stack을 사용하는 것에서 top 포인터만 사용하는 방법으로 변경
	 */
	void NTS_Q5() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char test_case[] = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int top = 1;
		int length = test_case.length;
		
		for(int i=0; i<length; i++){
			char c = test_case[i];
			
			if(Character.isAlphabetic(c)){
				for(int j=0; j<top; j++){
					sb.append(c);
				}
				top = 1;
			}
			else{
				top = c - '0';
			}
		}
		
		System.out.println(sb);
	}
	
	/**
	 * @문제	: 2017 NTS 동계인턴 코딩테스트 4번문제  											
	 * @날짜	: 18.04.29											
	 * @풀이	: 두 개의 문자열 숫자배열을 받아서 변환 라이브러리 사용하지 않고 덧셈하기
	 * parseInt 직접 구현. result=0 초기화 후에 radix 곱해서 자릿수별로 -'0' 계산											
	 */		
	int NTS_Q4(String str){
		int result = 0;
		
		for(int i=0; i<str.length(); i++){
			result = (result*10) + str.charAt(i) - '0';
		}
		return result;
	}
	
	/**
	 * @문제	: 	괄호										
	 * @날짜	:	18.04.29										
	 * @풀이	:	스택을 이용. 이 문제같은 경우 실질적으로 스택에 쌓이는
	 * 괄호는 쓰이지 않고 empty의 유무에 따라 결과값만 체크해주면 되므로
	 * stack을 할당하지 않고 top 값의 증감만으로도 풀 수 있다.
	 * 
	 * toCharArray 하면 모든 String을 다 변환하기 때문에 시간이 더 오래걸릴 수도 있다.
	 * 경우에 따라서 .charAt(index) 해줄 것										
	 */		
	void Q9012() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nCase = Integer.parseInt(br.readLine());
		int top = -1;

		StringBuilder sb = new StringBuilder();

		while (nCase-- > 0) {
			String PS = br.readLine();

			for (int i = 0; i < PS.length(); i++) {
				char c = PS.charAt(i);

				if (c == '(') {
					top++;
				} else {
					top--;
					if (top < -1)
						break;
				}
			}

			sb.append(top != -1 ? "NO\n" : "YES\n");
			top = -1;
		}

		System.out.println(sb);
		
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Object> stack = new Stack<Object>();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test_case ; i++){
			String str = br.readLine();
			
			for(int j=0; j<str.length(); j++){
				char c = str.charAt(j);
				if(c =='('){
					stack.push(c);
				}
				else{
					if(stack.isEmpty()){
						stack.push('(');
						break;
					}
					else{
						stack.pop();
					}
				}
			}
			
			if(stack.isEmpty()){
				sb.append("YES\n");
			}
			else{
				sb.append("NO\n");
			}
			
			stack.clear();
		}
		System.out.println(new String(sb));*/
	}
	
	/**
	 * @문제	: 쇠막대기											
	 * @날짜	: 18.04.29											
	 * @풀이	: stack을 사용할 때는 꼭 stack 객체를 생성해야하는지, 
	 * top만 있어도 가능한지 생각을 해보자. 
	 * charAt(i) 보다는 toCharArray가 다소 빠르다.
	 * stack을 안쓰고 top만 이용하면 속도가 당연히 더 빠르다. 											
	 */		
	void Q10799() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String testCase = input.readLine();
		
		int top = 0;
		int result = 0;
		
		for(int i=0; i<testCase.length(); i++){
			char c = testCase.charAt(i);
			
			if(c == '('){
				top++;
			}else{
				top--;		
				result += testCase.charAt(i-1) == '(' ? top : 1;
			}
		}
		
		System.out.println(result);	
	}
	
	/**
	 * @문제	: 	음계										
	 * @날짜	:	18.04.29										
	 * @풀이	:	원래는 배열을 이용해서 풀어야 하지만 간단하게 문자열로 한번에 비교 
	 * 정석대로 풀려면 char배열에 br.readLine().split(" ") 저장해서 배열로 계산 										
	 */		
	void Q2920() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test_case = br.readLine();
		
		if(test_case.equals("1 2 3 4 5 6 7 8")){
			System.out.println("ascending");
		}
		else if(test_case.equals("8 7 6 5 4 3 2 1")){
			System.out.println("descending");
		}
		else{
			System.out.println("mixed");
		}
	}
	
	/**
	 * @문제	: 나는 요리사다										
	 * @날짜	: 18.04.29											
	 * @풀이	: br.readLine().split(" ") 사용하여 풀이 
	 * char 형 배열이 아니라 String 배열을 사용함을 주의 											
	 */		
	void Q2953() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int id = 0;
		
		for(int i=1; i<=5; i++){
			String test_case[] = br.readLine().split(" ");
			int sum=0;
			
			for(String s : test_case){
				sum += Integer.parseInt(s);
			}
			if(max < sum){
				max = sum;
				id = i;
			}
		}
		System.out.println(id+" "+max);
	}
	
	/**
	 * @문제	: 	2017 NTS 동계인턴 3번 문제										
	 * @날짜	:	18.04.30										
	 * @풀이	:	두 개의 문자열 배열을 입력 받아 중복된 알파벳을 중복 없이 출력하기
	 * 최적의 조건. HashSet.contains() 는 복잡도가 O(1) 이다. 따라서 총 시간복잡도는 O(n)										
	 */		
	void NTS_Q3_1() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		HashSet<String> case1 = new HashSet<String>();
		HashSet<String> result = new HashSet<String>();
		
		while(st.hasMoreTokens()){
			case1.add(st.nextToken());
		}
		
		String case2[] = br.readLine().split(" ");
		int len = case2.length;
		
		for(int i=0; i<len; i++){
			String word = case2[i];
			if(case1.contains(word)){
				result.add(word);
			}
		}
		
		for(String word : result){
			sb.append(word+" ");
		}
		
		System.out.println(sb);
	/*	
		private static void solution(String[] arr1, String[] arr2) {
			HashSet<String> set1 = new HashSet<>();
			Collections.addAll(set1, arr1);
			
			HashSet<String> result = new HashSet<>();
			
			for(String s : arr2){
				if(set1.contains(s)){
					result.add(s);
				}
			}
			
			StringBuilder output = new StringBuilder();
			
			for(String s : result){
				output.append(s+" ");
			}
			
			System.out.println(output);
		}
	*/
	}
	
	
	/**
	 * @문제	: 	2017 NTS 동계인턴 3번 문제										
	 * @날짜	:	18.04.30										
	 * @풀이	:	두 개의 문자열 배열을 입력 받아 중복된 알파벳을 중복 없이 출력하기
	 * 최악의 조건.
	 * 배열을 2중 중첩 + ArrayList.contains() 하여 총 시간복잡도 O(n^3) 
	 * Set 대신 배열리스트를 선언했기 때문에 최대 size/2 만큼 메모리를 낭비할 수 있다.
	 * (배열리스트는 add()함수로 새로 할당할 영역이 부족하면 size*3/2+1 만큼 사이즈를 변경하고 복사한다.)
	 * StringBuilder 대신 syso 사용하여 속도가 느리다. 									
	 */		
	void NTS_Q3_2() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char case1[] = br.readLine().toCharArray();
		char case2[] = br.readLine().toCharArray();
		
		ArrayList<Character> result = new ArrayList<Character>();
		
		for(int i=0; i<case1.length; i++){
			char compareA = case1[i];
			
			for(int j=0; j<case2.length; j++){
				 char compareB = case2[j];
				 
				 if(compareA == compareB){
					 if(!result.contains(compareB)){
						 result.add(compareB);
					 }
				 }
			}
		}
		
		for(char r : result){
			System.out.println(r+" ");
		}
	}
	
	/**
	 * @문제	: 	Stack 이용한 후위연산 계산										
	 * @날짜	:	18.04.30										
	 * @풀이	: 	char 형을 int로 계산할 때 강제 형변환이 되지 않는다.
	 * - '0' 을 반드시 해줄 것!! 
	 * 1. 피연산자가 나오면 push
	 * 2. 연산자가 나오면 pop 2번하여 계산(num2 - num1)
	 * 3. 결과값을 다시 push
	 */
	void postFixCalcul(String line){
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<line.length(); i++){
			int item = line.charAt(i);
			
			if(Character.isDigit(item)){
				stack.push(item-'0');
			}
			else{
				int num1 = stack.pop();
				int num2 = stack.pop();
				
				switch(item){
				case '+': stack.push(num2 + num1); break;
				case '-': stack.push(num2 - num1); break;
				case '*': stack.push(num2 * num1); break;
				case '/': stack.push(num2 / num1); break;
				}
			}
		}
		int result = stack.pop();
		System.out.println(result);
	}
	
	
	/**
	 * @문제	:  스택으로 중위연산을 후위연산식 만들기 										
	 * @날짜	:  18.04.30										
	 * @풀이	:  식 = formula, StringBuilder 사용
	 * 1. 숫자면 append
	 * 2. ')' 나오면 '(' 나올 때 까지 pop연산 + append
	 * 3. '(' 무조건 push	
	 * 
	 * @수정 	: 조건부 추가, 미완성, 예외 case : a+b+c*d									
	 */		
	void Q1918() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		char formula[] = br.readLine().toCharArray();
		
		for(int i=0; i<formula.length; i++){
			char word = formula[i];
			
			if(Character.isAlphabetic(word)){
				sb.append(word);
			}
			else if(word == ')'){
				while(!stack.isEmpty()){
					char top = stack.pop();
					
					if(top == '('){
						break;
					}	
					
					sb.append(top);
				}
			}
			else if(word =='*' || word == '/'){
				
				if(!stack.isEmpty() && stack.peek() != '('){
					sb.append(formula[++i]);
					sb.append(word);
					
					if(stack.peek() == '*' || stack.peek() == '/'){
						sb.append(stack.pop());
					}
					
				}else{
					sb.append(formula[++i]);
					sb.append(word);
				}
			}
			else if(!stack.isEmpty() && (word == '+' || word == '-')){
				if(stack.peek() != '('){
					sb.append(stack.pop());
					stack.push(word);
				}
				else{
					stack.push(word);
				}
			}
			else{
				stack.push(word);
			}
		}
		
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
	
	/**
	 * @문제	: 	좋은 단어										
	 * @날짜	:	18.05.01										
	 * @풀이	:	stack										
	 */		
	void Q3986() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		
		int result = 0;
		int re = Integer.parseInt(br.readLine());
		
		while(re-->0){
		
			char test_case[] = br.readLine().toCharArray();
			int len = test_case.length;
			
			for(int i=0; i<len; i++){
				char data = test_case[i];
				
				if(stack.isEmpty()){
					stack.push(data);
				}
				else{
					if(data == stack.peek()){
						stack.pop();
					}
					else{
						stack.push(data);
					}
				}
				
				if(stack.size() > len/2){
					break;
				}
			}
			
			if(stack.isEmpty()){
				result++;
			}
		
			stack.clear();
		}
		
		System.out.println(result);
	}
	
	/**
	 * @문제	:  탑 (길이가 다른 탑에서 나란히 전파를 왼쪽으로 쐈을 때 가장 먼저 신호를 받는 탑 index 찍기)											
	 * @날짜	:  18.05.01											
	 * @풀이	:  Stack으로 풀이. Tour 객체에 높이와 거리 정보를 담는다.
	 * 이전 탑들보다 더 큰 탑이 나왔을 경우 이전 탑들은 없어져도 상관없다. 
	 * 첫번째로 신호를 받는 탑만 계산하면 되기 때문. 
	 * inner class		 								
	 */		
	void Q2493() throws IOException{
		
		class Tour{
			int height;
			int index;
			
			Tour(int h, int i){
				this.height = h;
				this.index = i;
			}
		}
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		Stack<Tour> stack = new Stack<>();
		
		StringBuilder output = new StringBuilder();
		int nCase = Integer.parseInt(input.readLine());
		
		String tours[] = input.readLine().split(" ");
		
		for(int i=0; i<nCase; i++){
			int height = Integer.parseInt(tours[i]);
			
			if(stack.isEmpty()){
				stack.push(new Tour(height, i+1));
				output.append("0 ");
				
			} else{
				int receiveTour = 0;
				
				while(!stack.isEmpty()){
					int preHeight = stack.peek().height;
					
					if(preHeight >= height){
						receiveTour = stack.peek().index;
						stack.push(new Tour(height, i+1));
						break;
					}
					stack.pop();
				}	
				
				output.append(receiveTour+" ");
				
				if(stack.isEmpty()){
					stack.push(new Tour(height, i+1));
				}		
			} // else
		} // for
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 숫자카드2 (두 개의 숫자 배열 주고 몇 장의 숫자가 들어있는지 계산) 											
	 * @날짜	: 18.05.01 											
	 * @풀이	: HashMap 으로  key값 탐색, value값 증가 연산으로 풀이											
	 */		
	void Q10816() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> card = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		String []storage = br.readLine().split(" ");
		
		for(int i=0; i<N; i++){
			int item = Integer.parseInt(storage[i]);
			
			if(card.containsKey(item)){
				int num = card.get(item);
				card.put(item, num+1);
			}
			else{
				card.put(item, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();		
		int M = Integer.parseInt(br.readLine());
		String []cardList = br.readLine().split(" ");
		
		for(int i=0; i<M; i++){
			int item = Integer.parseInt(cardList[i]);
			
			if(card.containsKey(item)){
				sb.append(card.get(item)+" ");
			}
			else{
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
	
	/**
	 * @문제	: 	Quick Sort 구현										
	 * @날짜	:	18.05.02										
	 * @풀이	:	복습
	 * @수정	:   while 조건문 i<=right를 앞으로.. 앞의 조건을 한번 더 돌기 때문에
	 * outOfIndex Exception 발생  										
	 */	
	void quickSort(int arr[], int left, int right){
		int i = left+1;
		int j = right;
		int mid = (left+right) / 2;
		int p = arr[mid];
		
		if(i > j){
			return;
		}
		
	//	swap(arr, i, mid);
		
		while(i <= j){
			while(i <= right && arr[i] <= p) i++;
			while(j >= left+1 && arr[j] >= p) j--;
			
			if(i < j){
				// swap(arr, i, j);
			}
		}
		
		// swap(arr, j, left);
		quickSort(arr, left, j-1);
		quickSort(arr, j+1, right);
	}
	
	/**
	 * @문제	: 	공유기 설치										
	 * @날짜	:	18.05.03										
	 * @풀이	:	파라메트릭 서치(이분 탐색)
	 * 1. 오름차순 정렬
	 * 2. mid를 기준으로 gap 계산해서 gap이 크면 공유기 ++
	 *    mid에  공유기를 설치했으니 mid값보다 작으면 공유기를 설치할 필요가 없다.
	 * 3. 공유기가 총 갯수보다 적게 설치 됐으면 mid - 1 간격을 좁힌다.
	 *    많이 설치 됐으면 mid+1 간격을 넓힌다. 									
	 */		
	void Q2110() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int num = Integer.parseInt(st.nextToken());
		int stock = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[num];
		
		for(int i=0; i<num; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1;
		int right = arr[num-1] - arr[0];
		int gap = 0;
		int ans = 0;
		
		while(left <= right){
			int mid = (left + right) / 2;
			int start = arr[0];
			int cnt = 1;
			
			for(int i=1; i<num; i++){
				gap = arr[i] - start;
				
				if(mid <= gap){
					++cnt;
					start = arr[i];
				}
			}
			
			if(cnt >= stock){
				System.out.printf("[>=] left: %d, rigth: %d, mid: %d, cnt: %d\n",left, right, mid, cnt);
				ans = mid;
				left = mid + 1;
			}
			else{
				System.out.printf("left: %d, right: %d, mid: %d, cnt: %d\n", left, right, mid, cnt);
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}
	
	/**
	 * @문제	: 	그룹 단어 체커										
	 * @날짜	:	18.05.06										
	 * @풀이	:	
	 * 1. 각 자릿수 단어를 HashSet에 넣는다.
	 * 2. contains 라면 word[index-1] 과 비교해보고 단어가 다르면 false 리턴
	 * 3. word를 다 돌았을 때 체커가 true 라면 count ++
	 * 4. HashSet clear() 하고 1~3 과정 반복										
	 */		
	void Q1316() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> hs = new HashSet<Character>();
		int result = 0;
		boolean check = true;
		
		int re = Integer.parseInt(br.readLine());

		for (int i = 0; i < re; i++) {
			char word[] = br.readLine().toCharArray();
			int len = word.length;

			for (int j = 0; j < len; j++) {
				char c = word[j];

				if (hs.contains(c)) {
					if (c != word[j - 1]) {
						check = false;
						break;
					}
				} 
				else {
					hs.add(c);
				}
			}

			if (check == true) {
				result++;
			}
			hs.clear();
			check = true;
		}

		System.out.println(result);
	}
	
	
	/**
	 * @문제	: 유학 금지										
	 * @날짜	: 18.06.02											
	 * @풀이	: 금지 단어를 설정하고 문자를 입력받아 금지 단어 제외 문자열 출력	
	 * 백준 문제풀이 자바기준 15위 .. !										
	 */		
	void Q2789() throws IOException{
		HashSet<Character> censorship;

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
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char inputText[] = br.readLine().toCharArray();

		StringBuilder sb = new StringBuilder();

		for (char word : inputText) {
			if (!censorship.contains(word)) {
				sb.append(word);
			}
		}
		System.out.println(sb);
	}
	
	/**
	 * @문제	: 	IOI JOI 문자열 구하기										
	 * @날짜	:	18.06.02										
	 * @풀이	:	문자열을 charArray로 변환하여 index별 접근										
	 */		
	void Q5586() throws IOException{
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
	
	
	/**
	 * @문제	: 알파벳 개수 찾기 											
	 * @날짜	: 18.06.02											
	 * @풀이	: 문자열 속에 알파벳이 몇개 들어있는지 세고 
	 * 가장 많이 나온 알파벳 횟수 출력											
	 */		
	void S001() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int countTable[] = new int[26];
		
		char testCase[] = br.readLine().toCharArray();
		
		for(char word : testCase){
			countTable[25 - ('z'-word)]++;
		}
		
		StringBuilder sb = new StringBuilder();
		int maxCount = 0;
		
		for(int count : countTable){
			sb.append(count+" ");
			maxCount = maxCount < count ? count : maxCount;
		}
		
		System.out.println(sb);
		System.out.println(maxCount);
	}
	
	/**
	 * @문제	: 숫자 찾기											
	 * @날짜	: 18.06.03											
	 * @풀이	: A 숫자 목록을 주고 B 숫자 목록 중에 A에 포함되어 있는 숫자 판별하기	
	 * 메모리를 많이 먹긴 하지만 실행속도 3위 문제..										
	 */		
	void Q1920() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hs = new HashSet<>();
		
		br.readLine();
		String N[] = br.readLine().split(" ");
		
		for(String n : N){
			hs.add(n);
		}
		
		br.readLine();
		String M[] = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for(String m : M){
			if(hs.contains(m)){
				sb.append("1\n");
			}
			else{
				sb.append("0\n");
			}
		}
		
		System.out.println(sb);
	}
	
	/**
	 * @문제	: 2017 NTS 동계인턴 1번 문제										
	 * @날짜	: 18.06.03											
	 * @풀이	: 카멜표기법과 언더바 문자열 들어오면 서로 바꿔 주는 것
	 * 
	 * ex) first_Test_Case <-> firstTestCase 											
	 */		
	void NTS_Q1() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		/*class Inner {
			void toCamelCase(String testCase) {
				StringBuilder output = new StringBuilder();
				char temp[] = testCase.toCharArray();

				for (char word : temp) {
					if (word != '_') {
						output.append(word);
					}
				}
				System.out.println(output);
			}

			void toHungCase(String testCase) {
				StringBuilder output = new StringBuilder();
				char temp[] = testCase.toCharArray();

				for (char word : temp) {
					if (Character.isUpperCase(word)) {
						output.append("_" + word);
					} else {
						output.append(word);
					}
				}
				System.out.println(output);
			}
		}
		
		Inner inner = new Inner(); 

		int nCase = Integer.parseInt(input.readLine());

		while (nCase-- > 0) {
			String testCase = input.readLine();

			if (testCase.contains("_")) {
				inner.toCamelCase(testCase);
			} else {
				inner.toHungCase(testCase);
			}
		}*/
	}
	
	/**
	 * @문제	: 방 번호 											
	 * @날짜	: 18.06.12											
	 * @풀이	: 배열을 이용. 6과 9는 /2 연산.											
	 */		
	void Q1475() throws IOException{
		int arr[] = new int[10];

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char number[] = input.readLine().toCharArray();

		for (char num : number) {
			int card = num - '0';

			if (card != 9) {
				arr[card]++;
			} else {
				arr[6]++;
			}
		}

		arr[6] = arr[6] % 2 == 0 ? arr[6] / 2 : arr[6] / 2 + 1;
		int max = 0;

		for (int card : arr) {
			max = max < card ? card : max;
		}

		System.out.println(max);
	}
	
	 /**
	 * @문제	: DFS / BFS											
	 * @날짜	: 18.06.12											
	 * @풀이	: 인접리스트로 그래프 구현											
	 */		
	void Q1260() throws IOException{
		 boolean visited[];
		 ArrayList<Integer>[] graph;
		 Queue<Integer> Q;
		 StringBuilder output;
		 
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(input.readLine());

		output = new StringBuilder();

		int N = Integer.parseInt(token.nextToken());
		int M = Integer.parseInt(token.nextToken());
		int V = Integer.parseInt(token.nextToken());

		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			token = new StringTokenizer(input.readLine());

			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());

			graph[x].add(y);
			graph[y].add(x);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1];
		//reset(visited);
		//DFS(V);
		output.append("\n");

		Q = new LinkedList<Integer>();
		//reset(visited);
		//BFS(V);
		System.out.print(output);
		
		class inner {
			
			void reset(boolean arr[]) {
				Arrays.fill(arr, false);
			}

			void BFS(int startPoint) {
				Q.add(startPoint);
				visited[startPoint] = true;

				while (!Q.isEmpty()) {
					int n = Q.poll();
					output.append(n + " ");

					for (int x : graph[n]) {
						if (!visited[x]) {
							visited[x] = true;
							Q.add(x);
						}
					}
				}
			}

			void DFS(int startPoint) {
				visited[startPoint] = true;
				output.append(startPoint + " ");

				for (int n : graph[startPoint]) {
					if (!visited[n]) {
						DFS(n);
					}
				}
			}
		}	
	}
	
	/**
	 * @문제	: 미로 찾기(DFS)											
	 * @날짜	: 18.06.12											
	 * @풀이	: 4방향으로 이동할 수 있는지 검증, 
	 * 이동 가능하면 큐에 넣고 다음 이동 포인트에 +1 
	 * 방문한 곳은 true로 											
	 */		
	void Q2178() throws IOException{
	/*	static int map[][];
		static boolean visited[][];
		static Queue<Point> queue;
		static int N;
		static int M;
		
		static int dx[] = {0,-1,0,1};
		static int dy[] = {1,0,-1,0};
		
		public static void main(String[] args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer token = new StringTokenizer(input.readLine());
			
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i=0; i<N; i++){
				String row = input.readLine();
				
				for(int j=0; j<M; j++){
					map[i][j] = row.charAt(j)-'0';
					visited[i][j] = false;
				}
			}
			
			queue = new LinkedList<Point>();
			find(0,0);
			
			System.out.println(map[N-1][M-1]);
			
			for(int i=0; i<N; i++){
				for(int j=0; j<M; j++){
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
		
		static void find(int x, int y){
			queue.add(new Point(x,y));
			visited[x][y] = true;
			
			while(!queue.isEmpty()){
				Point p = queue.poll();
				
				for(int i=0; i<4; i++){
					int nextX = p.x + dx[i];
					int nextY = p.y + dy[i];
					
					if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
						continue;
					}
					
					if(visited[nextX][nextY] || map[nextX][nextY] == 0){
						continue;
					}
					
					queue.add(new Point(nextX, nextY));
					map[nextX][nextY] = map[p.x][p.y] + 1;
					visited[nextX][nextY] = true;
				}
			}
			
		}
	}

	class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}*/
	}
	
	/**
	 * @문제	: 알파벳 빈도수 정렬 										
	 * @날짜	: 18.06.13											
	 * @풀이	: 알파벳 배열, 인덱스 배열 두개를 생성
	 * index배열을 정렬한다. 비교 기준은 알파벳 배열
	 * alphabet[index[i]] 으로 매핑시켜서 알파벳 출력											
	 */		
	void S002() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		int ALPHABET = 26;
		
		int alphabets[] = new int[ALPHABET];
		int index[] = new int[ALPHABET];
		
		for(int i=0; i<ALPHABET; i++){
			index[i] = i;
		}
		
		
		String testCase = input.readLine();
		
		for(int i=0; i<testCase.length(); i++){
			char c = testCase.charAt(i);
			alphabets[c-'A']++;
		}
		
		/*for(int i=1; i<26; i++){
			for(int j=0; j<26-i; j++){
				if(alphabets[index[j]] < alphabets[index[j+1]]){
					index[j] = index[j] ^ index[j+1];
					index[j+1] = index[j] ^ index[j+1];
					index[j] = index[j] ^ index[j+1];
				}
			}
		}*/
		
		
		for(int i=1, j; i<ALPHABET; i++){
			int key = index[i];
			
			for(j=i-1; j>=0 && alphabets[index[j]] < alphabets[key]; j--){
				index[j+1] = index[j];
			}
			index[j+1] = key;
		}
		
		for(int i=0; i<ALPHABET; i++){
			for(int count = alphabets[index[i]]; count>0; count--){
				output.append((char)(index[i]+'A'));
			}
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 단지 번호 붙이기										
	 * @날짜	: 18.06.13											
	 * @풀이	: 큐를 이용한 BFS풀이. 
	 * BFS 반복문에서 속도가 느려지는데 큐를 이용하지 않고
	 * 재귀 통해서 속도가 더 빨라질 수 있다.. 추후 연구할 것											
	 */		
	void Q2667() throws IOException{
		/*static boolean visited[][];
		static int map[][];
		static Queue<Dot> Q;
		static int Size;
		
		static int dx[] = {0, 1, 0, -1};
		static int dy[] = {1, 0, -1, 0};
		
		public static void main(String[] args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			Size = Integer.parseInt(input.readLine());
			
			map = new int[Size][Size];
			visited = new boolean[Size][Size];
			
			for(int i=0; i<Size; i++){
				String rowInfo = input.readLine();
				
				for(int j=0; j<Size; j++){
					map[i][j] = rowInfo.charAt(j)-'0';
					visited[i][j] = false;
				}
			}
			
			Q = new LinkedList<Dot>();
			ArrayList<Integer> nHome = new ArrayList<>();
			
			for(int i=0; i<Size; i++){
				for(int j=0; j<Size; j++){
					if(map[i][j] == 1){
						nHome.add(findHome(i, j));
					}
				}
			}
		
			System.out.println(nHome.size());
			
			Collections.sort(nHome);
		
			for(int size : nHome){
				System.out.println(size);
			}
		}
		
		static int findHome(int x, int y){
			int size = 1;
			
			Q.add(new Dot(x, y));
			visited[x][y] = true;
			
			while(!Q.isEmpty()){
				Dot d = Q.poll();
				
				for(int i=0; i<4; i++){
					int nextX = d.x + dx[i];
					int nextY = d.y + dy[i];
					
					if(nextX < 0 || nextY < 0 || nextX >= Size || nextY >= Size){
						continue;
					}
					else if(visited[nextX][nextY] || map[nextX][nextY] == 0){
						continue;
					}
					else{
						Q.add(new Dot(nextX, nextY));
						visited[nextX][nextY] = true;
						map[nextX][nextY] = 0;
						size++;
					}
				}
			}
			return size;
		}
	} 

	class Dot{
		int x;
		int y;
		
		Dot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}*/
	}
	
	/**
	 * @문제	: 우선순위큐 사용법 											
	 * @날짜	: 18.06.13											
	 * @풀이	: 우선순위 큐의 간단한 예제. 
	 * 1. 객체에 Comparable<E> 선언 하고
	 * 2. compareTo 구현
	 * 3. this가 인자보다 크면 1로 했을 때 오름차순 정렬		
	 * 4. Collections.reverseOrder, addAll(Queue)								
	 */		
	void S003(){
		
		class Person implements Comparable<Person>{
			int age;
			String name;
			
			Person(int age, String name){
				this.age = age;
				this.name = name;
			}

			@Override
			public int compareTo(Person person) {
				if(this.age > person.age){
					return 1;
				}else if(this.age < person.age){
					return -1;
				}else{
					return 0;
				}
			}
		}
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Person> Q = new PriorityQueue<Person>();
//		Queue<Person> Q = new LinkedList<Person>();
		
/*		getData(Q);
		printQ(Q);
		
		getData(Q);
		
		PriorityQueue<Person> reverseQ = new PriorityQueue<Person>(Q.size(), Collections.reverseOrder());
		reverseQ.addAll(Q);
		
		printQ(reverseQ);
		
		static void printQ(Queue<Person> Q){
			while(!Q.isEmpty()){
				System.out.println(Q.poll().name);
			}
			
			System.out.println();
		}
		
		static void getData(Queue<Person> Q){
			Q.offer(new Person(23,"James"));
			Q.offer(new Person(15,"Holand"));
			Q.offer(new Person(88,"Happer"));
			Q.offer(new Person(33,"Mario"));
			Q.offer(new Person(42,"Take"));
		}*/
	}
	
	/**
	 * @문제	: 다익스트라 우선순위 큐 최단경로 											
	 * @날짜	: 18.06.13											
	 * @풀이	: BFS랑 구현법이 다 비슷비슷한듯..
	 * 0. 정점+1 만큼 배열리스트 graph 크기와 거리배열, 방문배열 초기화. 1 indexing 위함. 
	 * 1. 거리 배열 MAX값으로 초기화
	 * 2. 맵 정보 리스트에 입력
	 * 3. 우선순위 큐를 사용하면 거리 오름차순 자동 정렬이라 속도 조금 더 빠르다
	 * 4. 현재 위치를 큐에 넣고 
	 * 5. 다음 위치 거리(가중치) - 거리 배열 정보의. > 현재 위치 거리 + 다음 거리 가중치
	 * 6. 결과적으로 거리배열[정점위치]에 최단경로 값이 저장된다.
	 * 7. 방문배열[정점위치]가 false라면 해당 경로가 존재하지 않음 											
	 */		
	void Q1753() throws IOException{
	/*	static PriorityQueue<Integer> queue;
		static ArrayList<Element>[] graph;
		static int distance[];
		static boolean visited[];
		static int nV, nE, K;
		
		public static void main(String[] args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			String firstCommand[] = input.readLine().split(" ");
			nV = Integer.parseInt(firstCommand[0]);
			nE = Integer.parseInt(firstCommand[1]);
			
			K = Integer.parseInt(input.readLine());
			
			graph = new ArrayList[nV+1];
			visited = new boolean[nV+1];
			distance = new int[nV+1];
			Arrays.fill(distance, Integer.MAX_VALUE);
			
			for(int i=1; i<=nV; i++){
				graph[i] = new ArrayList<Element>();
			}
			
			for(int i=0; i<nE; i++){
				String testCase[] = input.readLine().split(" ");
				
				int u = Integer.parseInt(testCase[0]);
				int v = Integer.parseInt(testCase[1]);
				int w = Integer.parseInt(testCase[2]);
				
				graph[u].add(new Element(v,w));
			}
			
			queue = new PriorityQueue<Integer>();
			
			dijkstra(K);
			printResult();
		}
		
		static void dijkstra(int startVertex){
			queue.add(startVertex);
			distance[startVertex] = 0;
			
			while(!queue.isEmpty()){
				int current = queue.poll();
				visited[current] = true;
				
				for(int i=0; i<graph[current].size(); i++){
					Element e = graph[current].get(i);
					
					int nextVertex = e.vertex;
					int nextWeight = e.weight;
					
					if(distance[nextVertex] > distance[current] + nextWeight){
						distance[nextVertex] = distance[current] + nextWeight;
						queue.add(nextVertex);
					}
				}
			}
		}
		
		static void printResult(){
			StringBuilder output = new StringBuilder();
			
			for(int i=1; i<=nV; i++){
				if(visited[i]){
					output.append(distance[i]+"\n");
				}else{
					output.append("INF\n");
				}
			}
			
			System.out.println(output);
		}
	}

	class Element{
		int vertex;
		int weight;
		
		Element(int vertex, int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}*/
	}
	
	/**
	 * @문제	: 파티. 방향 그래프 거리 구하기											
	 * @날짜	: 18.06.14 											
	 * @풀이	: 방향그래프는 A와 B지점 간에 in과 out거리가 다를 수 있다.
	 * 도착 X지점을 기준으로 각 정점 별 거리를 배열에 담고
	 * 나머지 지점에서 X로 거리 측정하며 비교
	 * ★일반 큐가 우선순위 큐보다 속도가 훨씬 빠르게 측정되었다.											
	 */		
	void Q1238_Dijkstra() throws IOException{
/*//	static PriorityQueue<Integer> q;
		static Queue<Integer> q;
		static ArrayList<Vertex>[] graph;
		static boolean visited[];
		static int distance[];
		static int nV, nE, X;
		
		public static void main(String[] args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			String firstCommand[] = input.readLine().split(" ");
			
			nV = Integer.parseInt(firstCommand[0]);
			nE = Integer.parseInt(firstCommand[1]);
			X = Integer.parseInt(firstCommand[2]);
			
			visited = new boolean[nV+1];
			distance = new int[nV+1];
			graph = new ArrayList[nV+1];
			
			init();
			
			for(int i=1; i<=nV; i++){
				graph[i] = new ArrayList<Vertex>();
			}
			
			for(int i=0; i<nE; i++){
				String testCase[] = input.readLine().split(" ");
				
				int u = Integer.parseInt(testCase[0]);
				int v = Integer.parseInt(testCase[1]);
				int w = Integer.parseInt(testCase[2]);
				
				graph[u].add(new Vertex(v,w));
			}
			
		//	q = new PriorityQueue<>();
			q = new LinkedList<Integer>();
			
			dijkstra(X);
			
			int xToHome[] = new int[nV+1];
			
			for(int i=1; i<=nV; i++){
				xToHome[i] = distance[i];
			}
			
			int max = 0;
			
			for(int i=1; i<=nV; i++){
				init();
				dijkstra(i);
				
				int totalDistance = distance[X] + xToHome[i];
				max = max < totalDistance ? totalDistance : max;
			}
			
			System.out.println(max);		
		}
		
		static void init(){
			Arrays.fill(visited, false);
			Arrays.fill(distance, Integer.MAX_VALUE);
		}
		
		static void dijkstra(int k){
			q.add(k);
			distance[k] = 0;
			
			while(!q.isEmpty()){
				int current = q.poll();
				visited[current] = true;
				
				for(int i=0; i<graph[current].size(); i++){
					Vertex v = graph[current].get(i);
					
					int next = v.no;
					int dis = v.weight;
					
					if(distance[next] > distance[current] + dis){
						distance[next] = distance[current] + dis;
						q.add(next);
					}
				}
			}
		}
	}

	class Vertex{
		int no;
		int weight;
		
		Vertex(int no, int weight){
			this.no = no;
			this.weight = weight;
		}
	}*/
	}
	
	/**
	 * @문제	: 방향 그래프 최단경로 찾기 플로이드 와샬										
	 * @날짜	: 18.06.14											
	 * @풀이	: 3중첩 for문 플로이드 와샬. 
	 * 1. 2차원 인접행렬, INF값 초기화, 배열 값은 가중치
	 * 2. 바깥쪽 for문부터 경유지>시작점>도착점
	 * 3. 시작과 도착이 같다면 가중치 0	
	 * 4. [시작][도착] > [시작][경유지] + [경유지][도착] 이라면 갱신	
	 * 다익스트라보다 느리지만 음수 가중치를 계산할 수 있다.
	 * 예외처리를 해주면 어느정도 속도 개선은 가능									
	 */		
	void Q1238_Floyd() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String mapInfo[] = input.readLine().split(" ");
		
		int INF = 1000*1000;
		
		int N = Integer.parseInt(mapInfo[0]);
		int M = Integer.parseInt(mapInfo[1]);
		int X = Integer.parseInt(mapInfo[2]);
		
		int graph[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++){
			Arrays.fill(graph[i], INF);
		}
		
		for(int i=0; i<M; i++){
			String testCase[] = input.readLine().split(" ");
			
			int x = Integer.parseInt(testCase[0]);
			int y = Integer.parseInt(testCase[1]);
			int weight = Integer.parseInt(testCase[2]);
			
			graph[x][y] = weight;
		}
		
		for(int k=1; k<=N; k++){			
			for(int i=1; i<=N; i++){
				if(graph[i][k] == INF){
					continue;
				}
				for(int j=1; j<=N; j++){ 
					if(graph[k][j] == INF){
						continue;
					}
					if(i==j) {
						graph[i][j] = 0;
					}
					else{
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}
		}
		
		int max = 0;
		
		for(int i=1; i<=N; i++){
			int cur = graph[i][X] + graph[X][i];
			max = max < cur ? cur : max;
		}
		
		System.out.println(max);
	}
	
	/**
	 * @문제	: 크로아티아 알파벳 											
	 * @날짜	: 18.06.15											
	 * @풀이	: 주어진 문자열에 크로아알파벳이 몇개 있는지.
	 * 1. 문자열의 마지막부터 검증
	 * 2. -, =가 나오는거 확인해서 count증가시키고 index 감소 
	 * HashMap 이용할 수도 있지만 속도는 이게 제일 빠른듯?
	 * if 경우의 수가 4개											
	 */		
	void Q2941() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String testCase = input.readLine();
		
		int count = 0;
		
		for(int i=testCase.length()-1; i>=0; i--){
			char word = testCase.charAt(i);
			
			if(word == '-'){
				count++;
				i--;
			}else if(word == '='){
				char pre = testCase.charAt(i-1);
				
				if(i-2 >=0 && pre == 'z'){
					char ppre = testCase.charAt(i-2);
					i = ppre == 'd' ? i-2 : i-1;
				}
				else{
					i = pre == 's' || pre =='c' ? i-1 : i;
				}
				count++;
				
			}else if(word == 'j'){
				char pre = testCase.charAt(i-1);
				
				if(pre == 'l' || pre == 'n'){
					i--;
				}
				count++;
			}else{
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	/**
	 * @문제	: 듣보잡 (문자열 검증, 정렬)											
	 * @날짜	: 18.06.15											
	 * @풀이	: 문자열 셋트 비교하고 문자열 정렬.
	 * 리스트객체에 담고 Collections.sort로 정렬											
	 */		
	void Q1764() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String firstCommand[] = input.readLine().split(" ");
		
		int N = Integer.parseInt(firstCommand[0]);
		int M = Integer.parseInt(firstCommand[1]);
		
		HashSet<String> unknows = new HashSet<>();
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++){
			unknows.add(input.readLine());
		}
		
		for(int i=0; i<M; i++){
			String noSee = input.readLine();
			
			if(unknows.contains(noSee)){
				result.add(noSee);
			}
		}
		
		Collections.sort(result);
		
		StringBuilder output = new StringBuilder();
		output.append(result.size()+"\n");
		
		for(String name : result){
			output.append(name+"\n");
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 직각삼각형 											
	 * @날짜	: 18.06.15											
	 * @풀이	: 세 변수 값을 입력 받아 직각삼각형인지 검증하기
	 * 1. 배열에 입력값을 담고 정렬해서 대각선 변 구하기. 											
	 */		
	void Q4153() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		
		int arr[] = new int[3];
		
		while(true){
			String testCase = input.readLine();
			
			if(testCase.equals("0 0 0")){
				break;
			}
			
			StringTokenizer token = new StringTokenizer(testCase); 
			
			arr[0] = Integer.parseInt(token.nextToken());
			arr[1] = Integer.parseInt(token.nextToken());
			arr[2] = Integer.parseInt(token.nextToken());
			
			Arrays.sort(arr);
			
			if(Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)){
				output.append("right\n");
			}else{
				output.append("wrong\n");
			}
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 하얀 칸 											
	 * @날짜	: 18.06.17											
	 * @풀이	: 체스판의 하얀 칸 위에 말이 몇개나 있는지
	 * i값에 따라 j를 삼항연산자로 계산해서 풀었는데 다른 방법에 비해 조금 느린 듯?								
	 */		
	void Q1100() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int count = 0;

		for (int i = 0; i < 8; i++) {
			String nCase = input.readLine();

			for (int j = i % 2 == 0 ? 0 : 1; j < 8; j += 2) {
				count = nCase.charAt(j) == 'F' ? count + 1 : count;
			}
		}

		System.out.println(count);
	}
	
	/**
	 * @문제	: 가장 많은 글자 찾기											
	 * @날짜	: 18.06.17											
	 * @풀이	: 문장을 입력받아서 가장 많은 알파벳 찾기. 등장 수가 같다면 알파벳 순 오름차순 출력
	 * 1. 처음 막혔던 부분은 EOF처리. (str = input.readLine()) != null 로 처리하는데 
	 * 콘솔에서는 무한 입력처리되도 백준에서는 자동 EOF 처리 되었다.(이거 몰라서 length !=0 비교까지 해서 콘솔에서는 실행되었는데 백준에서는 오답이더라)
	 * 2. 문자열 사이 모든 공백제거. str.replaceAll(" ","");
	 * 3. 오름 차순 정렬하고 맥스값들 배열리스트에 입력
	 * 4. 출력											
	 */		
	void Q1371() throws IOException{
		/*static int ALPHA = 26;
		static int alphabet[];
		static int index[];
		
		public static void main(String args[]) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			alphabet = new int[ALPHA]; 
			index = new int[ALPHA];
			String testCase;
			
			for(int i=0; i<ALPHA; i++){
				index[i] = i;
			}
			
			while((testCase = input.readLine()) != null){
				String trimString = testCase.replaceAll(" ", "");
				
				for(int i=0; i<trimString.length(); i++){
					alphabet[trimString.charAt(i) - 'a']++;	
				}
			}
			
			insertSort();			
			printAll();
		}
		
		static void printAll(){
			StringBuilder output = new StringBuilder();
			ArrayList<Character> result = new ArrayList<>();
			result.add((char)(index[0]+'a'));
			
			for(int i=1; i<ALPHA; i++){
				if(alphabet[index[i]] == alphabet[index[0]]){
					result.add((char)(index[i]+'a'));
				}else{
					break;
				}
			}
			
			Collections.sort(result);
			
			for(char c : result){
				output.append(c);
			}
			
			System.out.println(output);
		}
		
		static void insertSort(){
			for(int i=1,j; i<ALPHA; i++){
				int key = index[i];
				
				for(j=i-1; j>=0 && alphabet[index[j]] < alphabet[key]; j--){
					index[j+1] = index[j];
				}
				index[j+1] = key;
			}
		}*/
	}
	
	/**
	 * @문제	: 숨바꼭질 											
	 * @날짜	: 18.06.17											
	 * @풀이	: BFS 이용풀이. 
	 * 1. 방문여부 1차원 배열 
	 * 2. 방문배열이 초기값이 아니라면 이미 누가 먼저 왔다는 뜻이므로 패스
	 * 3. if 조건문에서 배열index 접근이 아니라 범위값먼저 검증해야 한다.(배열인덱스 오류)											
	 */		
	void Q1697() throws IOException{
		/*static Queue<Integer> queue;
		static int visited[] = new int[100001];
		static int N, K;
		
		public static void main(String args[]){
			Scanner scan = new Scanner(System.in);
			N = scan.nextInt();
			K = scan.nextInt();
			
			queue = new LinkedList<Integer>();
			BFS(N);
			System.out.println(visited[K]-1);	
		}
		
		static void BFS(int n){
			queue.add(n);
			visited[n] = 1;	
			
			while(!queue.isEmpty()){
				int v = queue.poll();
				
				if(v == K){
					break;
				}
				
				if(v+1 <= K && visited[v+1] == 0){
					queue.add(v+1);
					visited[v+1] = visited[v]+1;
				}
				
				if(v-1 >= 0 && visited[v-1] == 0){
					queue.add(v-1);
					visited[v-1] = visited[v]+1;
				}
				
				if(v*2 <= 100000 && visited[v*2] == 0){
					queue.add(v*2);
					visited[v*2] = visited[v]+1;
				}		
			}
		}*/
	}
	
	/**
	 * @문제	: 블랙잭											
	 * @날짜	: 18.06.17											
	 * @풀이	: 배열 문제.
	 * N장의 카드중 3장으로 M에 근접한 수를 출력하는 문제.
	 * 어차피 모든 경우의 수를 따져야 하기 때문에 정렬은 하지 않아도 된다.
	 * card1 = i, card2 = card1 + 1, card3 = card2 + 1 부터 비교											
	 */		
	void Q2798() throws IOException{
		/*static int N, M;
		static int cards[];
		
		public static void main(String []args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer token = new StringTokenizer(input.readLine());
			
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			
			cards = new int[N];
			token = new StringTokenizer(input.readLine());
			
			for(int i=0; i<N; i++){
				cards[i] = Integer.parseInt(token.nextToken());
			}
			
			System.out.println(solve());
		}
		
		static int solve(){
			int max = 0;
			
			for(int i=0; i<N-2; i++){
				for(int j=i+1; j<N-1; j++){
					
					if(cards[i] + cards[j] > M){
						continue;
					}
					
					for(int k=j+1; k<N; k++){
						int sum = cards[i] + cards[j] + cards[k];
						
						if(sum == M){
							return M;
						}else if(sum > M){
							continue;
						}else{
							max = sum > max ? sum : max;
						}
					}
				}
			}
			return max;
		}*/
	}
	
	/**
	 * @문제	: 최소비용 구하기(다익스트라) 											
	 * @날짜	: 18.06.17 											
	 * @풀이	: 큐 반복문에서 최소거리 구할 때
	 * 반드시 if조건절 먼저 넣어줄 것.
	 * 모든 경우에 대해 distance[cur] = Math()
	 * 해버리면 시간이 더 오래걸린다.											
	 */		
	void Q1916() throws IOException{
	   
/*		static Queue<Integer> queue;
		static ArrayList<Vertex> graph[];
		static int distance[];
		static boolean visited[];
		static int N, M, S, K;
		
		public static void main(String []args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			N = Integer.parseInt(input.readLine());
			M = Integer.parseInt(input.readLine());
			
			visited = new boolean[N+1];
			distance = new int[N+1];
			graph = new ArrayList[N+1];
			
			Arrays.fill(distance, 100000*100000+1);
			
			for(int i=1; i<=N; i++){
				graph[i] = new ArrayList<Vertex>();
			}
			
			for(int i=0; i<M; i++){
				String nCase[] = input.readLine().split(" ");
				
				int x = Integer.parseInt(nCase[0]);
				int y = Integer.parseInt(nCase[1]);
				int w = Integer.parseInt(nCase[2]);
				
				graph[x].add(new Vertex(y,w));
			}
			
			String testCase[] = input.readLine().split(" ");
			
			S = Integer.parseInt(testCase[0]);
			K = Integer.parseInt(testCase[1]);
			
			queue = new LinkedList<Integer>();
			Dijkstra(S);
			System.out.println(distance[K]);
		}
		
		static void Dijkstra(int s){
			queue.add(s);
			distance[s] = 0;
			
			while(!queue.isEmpty()){
				int cur = queue.poll();
				visited[cur] = true;
				
				for(int i=0; i<graph[cur].size(); i++){
					Vertex next = graph[cur].get(i);
					
					int p = next.p;
					int dis = next.distance;
					
					if(distance[next.p] > distance[cur]+next.distance){
						distance[next.p] = distance[cur]+next.distance;
						queue.add(next.p);
					}
				}
			}
		}
	}

	class Vertex{
		int p;
		int distance;
		
		Vertex(int p, int distance){
			this.p = p;
			this.distance = distance;
		}
	}*/	
		
	} // Q1916
	
	/**
	 * @문제	: 상근 버거(최소값 구하기)										
	 * @날짜	: 18.06.18											
	 * @풀이	: 간단하게 Arrays 정렬.. 											
	 */		
	void Q5543() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int bugers[] = new int[3];
		
		bugers[0] = Integer.parseInt(input.readLine());
		bugers[1] = Integer.parseInt(input.readLine());
		bugers[2] = Integer.parseInt(input.readLine());
		
		Arrays.sort(bugers);
		
		int drinks[] = new int[2];
		
		drinks[0] = Integer.parseInt(input.readLine());
		drinks[1] = Integer.parseInt(input.readLine());
	
		System.out.println((drinks[0]>drinks[1] ? drinks[1] : drinks[0]) + bugers[0] - 50);
	}
	
	
	
	/**
	 * @문제	: 차액 구하기											
	 * @날짜	: 18.06.18											
	 * @풀이	: Scanner 보다 BufferedReader로 읽는게 더 빠른듯											
	 */		
	void Q5565() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int result = Integer.parseInt(input.readLine());
		
		for(int i=0; i<9; i++){
			result -= Integer.parseInt(input.readLine());
		}
		
		System.out.println(result);
	}
	
	/**
	 * @문제	: 좌표 정렬(Comparable, Comparator 구현)											
	 * @날짜	: 18.06.18											
	 * @풀이	: Comparable 과 Comparator의 구현 차이 숙지할 것.
	 * 단일 정렬 Comparable + compareTo // 다중 정렬 Comparator + compare	
	 * Arrays.sort or Collections.sort 										
	 */		
	void Q6283() throws IOException{	
	//	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		/*class Dot { // implements Comparable<Dot>{
			int x;
			int y;
			
			Dot(int x, int y){
				this.x = x;
				this.y = y;
			}
			
			public int compareTo(Dot dot){
				if(this.x > dot.x){
					return 1;
				}else if(this.x < dot.x){
					return -1;
				}else{
					return this.y >= dot.y ? 1 : -1; 
				}
			}
		}*/
		
		/*ArrayList<Dot> dots = new ArrayList<Dot>();
		int nCase = Integer.parseInt(input.readLine());
		
		while(nCase-- > 0){
			StringTokenizer token = new StringTokenizer(input.readLine());
			
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
			
			dots.add(new Dot(x, y));
		}
			
		Collections.sort(dots, new Comparator<Dot>(){

			public int compare(Dot d1, Dot d2) {
				if(d1.x == d2.x){
					return Integer.compare(d1.y, d2.y);
				}
				
				return Integer.compare(d1.x, d2.x);
			}
		});
		
		StringBuilder output = new StringBuilder();
		
		for(Dot d : dots){
			output.append(d.x+" "+d.y+"\n");
		}
		
		System.out.println(output);*/
	}
	
	/**
	 * @문제	: 단어 정렬											
	 * @날짜	: 18.06.18											
	 * @풀이	: 중복 없이 문자열 길이와 사전순으로 다중 정렬.
	 * 1. 중복 검증위해서 HashSet 입력
	 * 2. Set을 List로 변환
	 * 3. Comparator 구현 											
	 */		
	void Q1181() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		HashSet<String> words = new HashSet<String>();
		int nCase = Integer.parseInt(input.readLine());

		while (nCase-- > 0) {
			words.add(input.readLine());
		}

		ArrayList<String> wordList = new ArrayList(words);
		Collections.sort(wordList, new Comparator<String>() {

			public int compare(String o1, String o2) {

				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() > o2.length() ? 1 : -1;
			}
		});

		StringBuilder output = new StringBuilder();

		for (String w : wordList) {
			output.append(w + "\n");
		}

		System.out.println(output);
	}
	
	/**
	 * @문제	: 접미사 배열											
	 * @날짜	: 18.06.19											
	 * @풀이	: substring(idx(다음부터), idx(전까지))											
	 */		
	void Q3382() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String testCase = input.readLine();
		ArrayList<String> words = new ArrayList<>();

		for (int i = 0; i < testCase.length(); i++) {
			words.add(testCase.substring(i, testCase.length()));
		}

		Collections.sort(words);

		StringBuilder output = new StringBuilder();

		for (String s : words) {
			output.append(s + "\n");
		}

		System.out.println(output);
	}
	
	
	/**
	 * @문제	: 5와 6의 차이											
	 * @날짜	: 18.06.19											
	 * @풀이	: replaceAll을 이용하면 간단하다.
	 * 주의사항 : replaceAll은 결과값 String을 반환한다. 원본값 변경 X	
	 * char배열을 String으로 바꿀 때 
	 * new String(char[]) 처럼 해야 한다.
	 * .toString() 을 해버리면 아스키코드 값들이 String으로 변환된다.										
	 */		
	void Q2864() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String testCase[] = input.readLine().split(" ");
		
		int min1 = Integer.parseInt(testCase[0].replaceAll("6", "5"));
		int min2 = Integer.parseInt(testCase[1].replaceAll("6", "5"));
		
		int max1 = Integer.parseInt(testCase[0].replaceAll("5", "6"));
		int max2 = Integer.parseInt(testCase[1].replaceAll("5", "6"));
		
		System.out.println((min1+min2)+" "+(max1+max2));
	}
	
	
	/**
	 * @문제	:  에라토스테네스의 체											
	 * @날짜	:  18.06.19											
	 * @풀이	:  체크할 배수만큼만 반복문을 돌면서 시간 최적화.											
	 */		
	void S004() throws IOException{
		int num = 100;
		
		int arr[] = new int[101];
		
		/* 입력받은 수 만큼 배열에 모두 초기화 */
		for(int i=2; i<=100; i++){
			arr[i] = i;
		}
		
		/* 소수는 n의 배수가 아니어야 하므로 루트 n까지만 나누어 본다. */
		for(int i=2; i<=num /* Math.sqrt(num) */; i++){
			
			/* 이미 체크된 수의 배수는 확인하지 않는다 */
			if(arr[i]==0){
				continue;
			}
			
			/* i를 제외한 i의 배수들 0으로 체크 */
			for(int j=i+i; j<=num; j+=i){
				arr[j] = 0;
			}
		}
		
		/* print */
		for(int i=2; i<=num; i++){
			if(arr[i]!=0)
				System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 * @문제	: 소수 구하기(주어진 수중 소수가 몇 개 있는가)											
	 * @날짜	: 18.06.19											
	 * @풀이	: 에라토스테네스의 체 이용											
	 */		
	void Q1978() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[1000];
		int count = 0;
		
		for(int i=2; i<1000; i++){
			arr[i] = i;
		}
		
		for(int i=2; i<1000; i++){
			if(arr[i]==0){
				continue;
			}
			for(int j=i+i; j<1000; j+=i){
				arr[j] = 0;
			}
		}
		
		input.readLine();
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		while(token.hasMoreTokens()){
			int n = Integer.parseInt(token.nextToken());
			
			if(arr[n] != 0){
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	/**
	 * @문제	: 에라스토테네스의 체											
	 * @날짜	: 18.06.19											
	 * @풀이	: 풀긴 풀었는데 속도가 느리다.
	 * visit배열을 만들어서 index로 접근하는게 속도가 빠를듯
	 * 나중에 수정해보자											
	 */		
	void Q2960() throws IOException{
	/*  Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		K = scan.nextInt();
		
		int sosu[] = new int[N+1];
		
		for(int i=2; i<=N; i++){
			sosu[i] = i;
		}
		
		System.out.println(Eratosthenes(sosu));
	}
	
	static int Eratosthenes(int sosu[]){
		int count = 0;
		
		if(K==1){
			return 2;
		}
		
		for(int i=2; i<=N; i++){
			if(sosu[i]== 0){
				continue;
			}
			count++;
			//System.out.println("count["+count+"] -- "+sosu[i]);			
			if(count == K){
				return sosu[i];
			}	
			
			for(int j=i+i; j<=N; j+=i){
				if(sosu[j] == 0){
					continue;
				}
				count++;
			//	System.out.println("count["+count+"] -- "+sosu[j]);
				if(count == K){
					return sosu[j];
				}		
				sosu[j] = 0;
			}			
		}
		return -1;*/
	}
	
	/**
	 * @문제	: 유클리드 호제법											
	 * @날짜	: 18.06.19											
	 * @풀이	: 최대공약수 얻는 공식
	 * 두 수중 큰수를 작은수로 나머지가 0이 될 때 까지 나눈다.
	 * 마지막에 큰 수가 최대공약수이며 
	 * 두 수의 곱에 최대공약수를 나누면 최소공배수가 나온다.											
	 */		
	void S005() throws IOException{
		int a = 12;
		int b = 8;
		
		int GCD = a > b ? Euclidean(a,b) : Euclidean(b,a);
		int LCM = a*b / GCD;
		
		System.out.println("LCM : "+LCM); //최소공배수
		System.out.println("GCD : "+GCD); //최대공약수
	}
	
	static int Euclidean(int num1, int num2){
		int remain = 1;
		
		while(remain > 0){
			remain = num1 % num2;
			num1 = num2;
			num2 = remain;
		}
		
		return num1;
	}
	
	/**
	 * @문제	: 0=not cute / 1 = cute 											
	 * @날짜	: 18.06.19											
	 * @풀이	: 구현								
	 */		
	void Q10886() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int nCase = Integer.parseInt(input.readLine());
		int vote = 0;
		
		for(int i=0; i<nCase; i++){
			vote = Integer.parseInt(input.readLine()) == 1 ? vote + 1 : vote;
		}
		
		if(vote < (double)nCase/2){
			System.out.println("Junhee is not cute!");
		}else{
			System.out.println("Junhee is cute!");
		}
	}
	
	
	/**
	 * @문제	: 나이순-가입순 다중정렬											
	 * @날짜	: 18.06.19											
	 * @풀이	: Comparable, Comparator 각각 구현해서 풀어봤는데
	 * Collection.sort 에서 Comparator로 바로 구현하는게 조금 속도 빠르다.
	 * if문 순서도 고려할 것											
	 */		
	void Q10814() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		class Person { //implements Comparable<Person>{
			int no;
			int age;
			String name;
			
			Person(int no, int age, String name){
				this.no = no;
				this.age = age;
				this.name = name;
			}

			/*public int compareTo(Person p) {
				if(this.age == p.age){
					return Integer.compare(this.no, p.no);
				}
				else if(this.age > p.age){
					return 1;
				}
				else{
					return -1;
				}
			}*/
		}
		
		int nCase = Integer.parseInt(input.readLine());
		ArrayList<Person> mans = new ArrayList<>();
		
		for(int i=0; i<nCase; i++){
			String person[] = input.readLine().split(" ");
			
			int age = Integer.parseInt(person[0]);
			String name = person[1];
			
			mans.add(new Person(i, age, name));
		}
		
	//	Collections.sort(mans);
		
		Collections.sort(mans, new Comparator<Person>(){

			public int compare(Person p1, Person p2) {
				if(p1.age > p2.age){
					return 1;
				}
				else if(p1.age < p2.age){
					return -1;
				}
				else{
					return p1.no > p2.no ? 1 : -1;
				}
			}
		});
		
		StringBuilder output = new StringBuilder();
		
		for(Person p : mans){
			output.append(p.age+" "+p.name+"\n");
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 점수 계산 										
	 * @날짜	: 18.06.19											
	 * @풀이	: 스코어 정렬 후에 문제 확인 index로
	 * true만 골라서 출력 											
	 */		
	void Q2822() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		class Quiz{
			int no;
			int score;
			
			Quiz(int no, int score){
				this.no = no;
				this.score = score;
			}
		}
		
		ArrayList<Quiz> scores = new ArrayList<>();
		boolean index[] = new boolean[9];
		
		for(int i=1; i<=8; i++){
			scores.add(new Quiz(i, Integer.parseInt(input.readLine())));
		}
		
		Collections.sort(scores, new Comparator<Quiz>(){
			public int compare(Quiz o1, Quiz o2) {
				return o1.score <= o2.score ? 1 : -1;
			}
		});
		
		StringBuilder output = new StringBuilder();
		int totalScore = 0;
		
		for(int i=0; i<5; i++){
			totalScore += scores.get(i).score;
			index[scores.get(i).no] = true;
		}
		
		output.append(totalScore+"\n");
		
		for(int i=1; i<=8; i++){
			if(index[i] == true)
				output.append(i+" ");
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 45분 전 시간 구하기											
	 * @날짜	: 18.06.20											
	 * @풀이	: 시간라이브러리 사용할 수 도 있지만 속도가 느리다.
	 * 간단한 시간계산 문제는 직접 구현하는 것이 두배는 빠르다.											
	 */		
	void Q2884() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		int hour = Integer.parseInt(token.nextToken());
		int minute = Integer.parseInt(token.nextToken());
		
		if(minute - 45 < 0){
			hour = hour - 1 < 0 ? 23 : hour - 1;
			minute = 60 + (minute - 45);
		}else{
			minute -= 45;
		}
		
		System.out.println(hour+" "+minute);
		
		/*SimpleDateFormat fmt = new SimpleDateFormat("H m");
		Date d = fmt.parse(input.readLine());
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, -45);
		
		System.out.println(fmt.format(cal.getTime()));*/
	}
	
	/**
	 * @문제	: 베스트셀러(가장 많이 팔린 책)										
	 * @날짜	: 18.06.20											
	 * @풀이	: HashMap을 keySet으로 List에 addAll 시킨 후 정렬.
	 * 1. 많이 팔린 책 - 같다면 사전 순 정렬이다.
	 * 2. HashMap으로 책 이름을 key값 검증. value를 증가
	 * 3. List에 keySet addAll
	 * 4. Collections.sort 로 HashMap.get(idx) 이용해서 정렬 기준 정의											
	 */		
	void Q1302() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int nCase = Integer.parseInt(input.readLine());
		Map<String, Integer> seller = new HashMap<>();
		
		while(nCase-- > 0){
			String book = input.readLine();
			
			if(seller.containsKey(book)){
				seller.put(book, seller.get(book)+1);
			}else{
				seller.put(book, 1);
			}
		}
		
		List<String> books = new ArrayList<>();
		books.addAll(seller.keySet());
		
		Collections.sort(books, new Comparator<String>(){
			
			public int compare(String o1, String o2) {
				
				if(seller.get(o1) == seller.get(o2)){
					return o1.compareTo(o2);
				}else{
					return Integer.compare(seller.get(o2), seller.get(o1));
				}
			}
		});
		
		System.out.println(books.get(0));
	}
	
	
	/**
	 * @문제	: 문자열 뒤집기											
	 * @날짜	: 18.06.20											
	 * @풀이	: 											
	 */		
	void S006() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		char testCase[] = input.readLine().toCharArray();
		
		StringBuilder output = new StringBuilder();
		
		for(int i=1; i<=testCase.length; i++){
			output.append(testCase[testCase.length-i]);
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 동전 2 (DP)											
	 * @날짜	: 18.06.20											
	 * @풀이	: 동전의 종류를 주고 잔돈에 최소로 맞추는 방법
	 * 0. DP배열 MAX값으로 초기화
	 * 1. 바깥 for: 코인 종류
	 * 2. 안쪽 for : dp배열(문제에서 제시하는 max값 까지)
	 * 3. DP[j] > DP[j-coin[i]]+1  
	 * 4. 이전의 값 + 자신의 값이 기존 값보다 작다면 갱신 
	 * 5. DP[value]에 결과값 저장											
	 */		
	void Q2294() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String command[] = input.readLine().split(" ");
		
		int nCase = Integer.parseInt(command[0]);
		int value = Integer.parseInt(command[1]);
		
		int INF = 10001;
		int coin[] = new int[nCase+1];
		int dp[] = new int[100001];
		
		for(int i=1; i<=nCase; i++){
			coin[i] = Integer.parseInt(input.readLine());
		}
		
		Arrays.fill(dp, INF);
		
		dp[0] = 0;
		
		for(int i=1; i<=nCase; i++){
			for(int j=coin[i]; j<=value; j++){
			//	System.out.println("-- j: "+j+" / dp[j-coin[i]+1 : "+(dp[j-coin[i]]+1));
				if(dp[j] > dp[j-coin[i]]+1){
				//	System.out.println("j: "+j+" / dp[j]: "+dp[j]+" / dp[j-coin[i]]+1 : "+(dp[j-coin[i]]+1));
					dp[j] = dp[j-coin[i]] + 1;
				}
			}
		}
		
		if(dp[value] == INF){
			System.out.println(-1);
		}else{
			System.out.println(dp[value]);
		}	
	}
	
	/**
	 * @문제	: 배낭 채우기 1 (DP)											
	 * @날짜	: 18.06.20											
	 * @풀이	: 무게와 가치가 다른 보석 종류를
	 * 정해진 가방 무게 안에 넣어 최대의 가치를 구하는 알고리즘
	 * 
	 * 1. 바깥 for : 보석의 종류
	 * 2. 안쪽 for : j= Wi[i] 부터 배낭 무게까지 
	 * 3. D[j] =  Math.max(D[j], D[j-Wi[i]] + Pi[i])
	 * 4. D[가방무게] 에 최대값 저장 											
	 */		
	void S007() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		int N = Integer.parseInt(token.nextToken());	// 보석의 수
		int W = Integer.parseInt(token.nextToken());	// 배낭무게(용량)
		
		int []Wi = new int[N + 1];	// 보석 무게
		int []Pi = new int[N + 1];  // 보석 가치
		int []D = new int[W + 1];   // DP 배열

		for (int i = 1; i <= N; i++) {
			token = new StringTokenizer(input.readLine());
			Wi[i] = Integer.parseInt(token.nextToken());
			Pi[i] = Integer.parseInt(token.nextToken());
		}

		// i 는 보석종류
		for (int i = 1; i <= N; i++) {
			// j는 보석 무게
			// 내 무게보다 작은 배낭은 이전에 구한값을 참고한다.
			for (int j = Wi[i]; j <= W; j++) {
				System.out.printf("[j = %d] --- D[j]: %d,   D[j-Wi[i]]: %d + Pi[i]: %d\n",j, D[j], D[j - Wi[i]], Pi[i]);
				D[j] = Math.max(D[j], D[j - Wi[i]] + Pi[i]);
			}
		}
		
		System.out.println(D[W]);
	}
	
	/**
	 * @문제	: 애너그램 만들기(몇 개의 단어를 지워야 하나?)										
	 * @날짜	: 18.06.22											
	 * @풀이	: 애너그램 관계 : 두 단어가 순서를 뒤집어 같을 때.
	 * 즉 두 문자열의 공통점만 빼고 다 지워야 한다. 
	 * 알파벳 배열에 등장 수를 카운팅하고 비교											
	 */		
	void Q1919() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int alpha[][] = new int[2][26];
		
		for(int i=0; i<2; i++){
			char testCase[] = input.readLine().toCharArray();
			
			for(int j=0; j<testCase.length; j++){
				alpha[i][testCase[j]-'a']++;
			}
		}
		
		int answer = 0;
		
		for(int i=0; i<26; i++){
			if(alpha[0][i] != alpha[1][i]){
				answer+=Math.abs(alpha[0][i]-alpha[1][i]);
			}
		}
		
		System.out.println(answer);
	}
	
	/**
	 * @문제	: 농구 경기(문자열 앞 글자만 따서 사전순 출력) 											
	 * @날짜	: 18.06.22											
	 * @풀이	: 
	 * 1. 알파벳 배열 구현
	 * 2. 앞자리만 카운팅
	 * 3. 알파벳 배열 돌면서 5이상만 출력											
	 */		
	void Q1159() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int alpha[] = new int[26];
		
		int nCase = Integer.parseInt(input.readLine());
		
		while(nCase-- > 0){
			String name = input.readLine();
			alpha[name.charAt(0)-'a']++;
		}
		
		StringBuilder output = new StringBuilder();
		
		for(int i=0; i<26; i++){
			if(alpha[i] >= 5){
				output.append((char)(i+'a'));
			}
		}
		
		if(output.toString().length() != 0){
			System.out.println(output);
		}else{
			System.out.println("PREDAJA");
		}
	}
	
	/**
	 * @문제	: 알파벳 빈도수 정렬 Comparator 버전 											
	 * @날짜	: 18.07.07											
	 * @풀이	: 디버깅모드 사용, index배열을 Comparator로 정렬											
	 */		
	void S008() throws IOException{
		/*static int ALPHA = 26;
		
		public static void main(String []args) throws IOException{
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			
			int alphabets[] = new int[ALPHA];
			Integer index[] = new Integer[ALPHA];
			
			String inputString = input.readLine();
			
			for(int i=0; i<ALPHA; i++){
				index[i] = i;
			}
			
			for(int i=0; i<inputString.length(); i++){
				alphabets[inputString.charAt(i)-'a']++;
			}
			
			Arrays.sort(index, new Comparator<Integer>(){
				
				@Override
				public int compare(Integer o1, Integer o2) {	
					return alphabets[o1] < alphabets[o2] ? 1 : -1;
				}
			});
			
			StringBuilder output = new StringBuilder();
			
			for(int i=0; i<ALPHA; i++){
				if(alphabets[index[i]]==0) break;
				
				output.append(alphabets[index[i]]);
				output.append((char)(index[i]+'a'));
			}
			
			System.out.println(output);
		}*/
	}
	
	void Q2399() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[Integer.parseInt(input.readLine())];
		
		StringTokenizer token = new StringTokenizer(input.readLine());
		
		for(int i=0; i<arr.length; i++){
			arr[i] = Integer.parseInt(token.nextToken());
		}
		
		long sum = 0;
		long result = 0;
		
		for(int i=0; i<arr.length-1; i++){
			sum = 0;
			
			for(int j=i+1; j<arr.length; j++){
				sum+=Math.abs(arr[i] - arr[j]);
			}
			
			//sum += (long) (2 * i + 1 - n) * arr[i];
			result+=sum*2;
		}
		
		System.out.println(result);
		
	}
	
	/**
	 * @문제	: University > 서강대학교 > 2014 Sogang Programming Contest - Master A번 										
	 * @날짜	: 18.08.07											
	 * @풀이	: 교수님의 지각 가능 시간을 묻는 문제.
	 * 수업시간 d, 지각시간 t일 때 수업이 일찍 끝나는 시간 s = t^2 이다. 
	 * t의 최대값을 구해야 하며,, d=6, t=2일 때 6 >= 2+(2^2) 이므로 t는 최대 2다.
	 *  											
	 */		
	void Q10419() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int nCase = Integer.parseInt(input.readLine());
		StringBuilder output = new StringBuilder();
		
		while(nCase-- > 0){
			int d = Integer.parseInt(input.readLine());
			int t = 1;
			
			while(d >= t+(t*t)){
				t++;
			}
			output.append(t-1+"\n");
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: University > 서강대학교 > 2014 Sogang Programming Contest - Master B번											
	 * @날짜	: 18.08.07											
	 * @풀이	: 기준 날짜로부터 n일째 되는날 출력
	 * 날짜 관련 라이브러리는 GregorianCalendar를 사용하도록 하자. 
	 * 월은 0~11 까지니 주의하도록											
	 */		
	void Q10420() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		
		GregorianCalendar cal = new GregorianCalendar(2014,3,1);
		cal.add(cal.DAY_OF_YEAR, Integer.parseInt(input.readLine()));
				
		System.out.println(fmt.format(cal.getTime()));
	}
	
	/**
	 * @문제	: 숫자 구음으로 바꾸기											
	 * @날짜	: 18.08.12											
	 * @풀이	: 100000 미만 까지만 가능. 추후 10만 이상 값이랑 0입력값 처리 추가해볼 것											
	 */		
	void S009() throws IOException{
		
		HashMap<Integer, String> digit = new HashMap<>();
		HashMap<Integer, String> placeValue = new HashMap<>();

		digit.put(1, "일");
		digit.put(2, "이");
		digit.put(3, "삼");
		digit.put(4, "사");
		digit.put(5, "오");
		digit.put(6, "육");
		digit.put(7, "칠");
		digit.put(8, "팔");
		digit.put(9, "구");

		placeValue.put(1, "");
		placeValue.put(2, "십");
		placeValue.put(3, "백");
		placeValue.put(4, "천");
		placeValue.put(5, "만");
		placeValue.put(6, "십");
		
		Scanner scan = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		
		String testCase = scan.next();
		
		//System.out.println((int)Math.log10(Integer.parseInt(testCase))+1);
		
		for(int i=0; i<testCase.length(); i++){
			int d = testCase.charAt(i)-'0';
			
			if(d == 0) continue;
			
			int p = (int)Math.log10(Integer.parseInt(testCase.substring(i)))+1;
					
			output.append(digit.get(d));
			output.append(placeValue.get(p));
		}
		
		if(testCase.charAt(testCase.length()-1) == '1'){
			output.append("일");
		}
		
		System.out.println(output);
	}
	
	/**
	 * @문제	: 나는야 포켓몬 마스터 이다솜											
	 * @날짜	: 18.08.14											
	 * @풀이	: names[] 배열과 HashMap으로 키값 으로 검색.
	 * 메모리 용량을 줄이려면 HashMap에 <String, String>으로 모두 입력하는 방법도 있다.
	 * Collection.list.indexOf(char[]) 은 시간이 오래 걸린다. 											
	 */		
	void Q1620() throws IOException{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String testCase[] = input.readLine().split(" ");
		
		int N = Integer.parseInt(testCase[0]);
		int M = Integer.parseInt(testCase[1]);
		
		String names[] = new String[N+1];
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=N; i++){
			String name = input.readLine();
			
			names[i] = name;
			map.put(name, i);
		}
		
		StringBuilder output = new StringBuilder();
		
		for(int i=0; i<M; i++){
			String key = input.readLine();
			
			if(map.containsKey(key)){
				output.append(map.get(key)+"\n");
			}else{
				output.append(names[Integer.parseInt(key)]+"\n");
			}
		}
		
		System.out.println(output);
	}
}
