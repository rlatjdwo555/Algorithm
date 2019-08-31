import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 카카오2017_1_뉴스클러스터링 {
	
	static HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
	static HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
	
	public static void main(String args[]) throws IOException, ParseException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		
		int ans = solution(str1, str2);
		
		System.out.println(ans);			
	}
	
	static public int solution(String str1, String str2){		
		int ans = 65536;
		
		if(str1.toUpperCase().equals(str2.toUpperCase())){
			return ans;
		}

		getPair(toCharArr(str1), hm1);
		getPair(toCharArr(str2), hm2);
		
		int intersection = hm1.size() >= hm2.size() ? getIntersection(hm2, hm1) : getIntersection(hm1, hm2);
		int union = hm1.size() >= hm2.size() ? getUnion(hm1, hm2) : getUnion(hm2, hm1);

		return (int)(((double)intersection/union)*ans);
	}

	static int getIntersection(Map<String, Integer> hm1, Map<String, Integer> hm2) {
		int cnt = 0;
		
		for(String key : hm2.keySet()){
			if(hm1.containsKey(key)){
				cnt += Math.min(hm1.get(key), hm2.get(key));
			}
		}
		
		return cnt;
	}
	
	static int getUnion(Map<String, Integer> hm1, Map<String, Integer> hm2) {
		for(String key : hm2.keySet()){
			if(hm1.containsKey(key)){
				hm1.put(key, Math.max(hm1.get(key), hm2.get(key)));
			}else{
				hm1.put(key, hm2.get(key));
			}
		}
		
		int cnt = 0;
		
		for(String key : hm1.keySet()){
			cnt += hm1.get(key);
		}
		
		return cnt;
	}

	static void getPair(char[] arr, HashMap<String, Integer> hs) {
		for(int i=0; i<arr.length-1; i++){
			char a = arr[i];
			char b = arr[i+1];
			
			if(Character.isAlphabetic(a) && Character.isAlphabetic(b)){
				String key = String.valueOf(a)+String.valueOf(b);
				hs.put(key, hs.getOrDefault(key, 0)+1);
			}
		}
	}

	static char[] toCharArr(String str){
		char arr[] = new char[(str.length()+1)/2*2];
		str = str.toUpperCase();
	
		for(int i=0; i<str.length(); i++){
			arr[i] = str.charAt(i);
		}
		
		return arr;
	}
}

