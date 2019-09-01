import java.io.*;
import java.util.*;

public class 카카오2018_1_오픈채팅방 {
	
	// 처음에 LinkedList 써서 시간초과가 발생했다.
	// 데이터가 10만개 정도 되면 급격하게 느려지는거 같다 유의하자.
	// 차라리 ArrayList로 사이즈 초기화하고 쓰는게 더 나을 뻔 했다.
	
	static HashMap<String, String> users = new HashMap<>();
	static HashMap<String, String> msg = new HashMap<>();
	static{
		msg.put("Enter", "님이 들어왔습니다.");
		msg.put("Leave", "님이 나갔습니다.");		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int m = 6;
		int n = 6;
		String arr1[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String arr2[] = {"Enter uid1234 Muzi"};
		
		String[] ans = solution(arr1);
 		System.out.println(Arrays.toString(ans));
	}
	
	static public String[] solution(String[] record) {
		int len = record.length;
		int logCount = 0;
		
		for(int i=0; i<len; i++){
			String log[] = record[i].split(" ");			
			String state = log[0];
					
			if(state.equals("Leave")){
				logCount++;
				continue;
			}
			
			String id = log[1];
			String name = log[2];
			users.put(id, name);
			
			if(state.equals("Enter")){
				logCount++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		String result[] = new String[logCount];
		int idx = 0;
		
		for(int i=0; i<len; i++){
			String log[] = record[i].split(" ");			
			String state = log[0];
			String id = log[1];
			
			if(state.equals("Change")){
				continue;
			}
			
			result[idx++] = sb.append(users.get(id)).append(msg.get(state)).toString();
			sb.delete(0, sb.length());
		}
		
		return result;
	}
}

