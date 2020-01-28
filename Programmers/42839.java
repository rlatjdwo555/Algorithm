import java.util.*;

class Solution {
    
    static HashSet<Integer> hs = new HashSet<>();
    static int ans = 0;
    static boolean use[];
    static char tmp[];
    static int N, M;
    
    public static int solution(String numbers) {
        N = numbers.length();
        use = new boolean[N];
        
        for(int i=1; i<=numbers.length(); i++){
            M = i;
            tmp = new char[M];
            dfs(0, numbers);
        }
        return ans;
    }
    
    public static void dfs(int idx, String numbers){
        if(idx == M){
        	StringBuilder sb = new StringBuilder();
        	for(int i=0; i<M; i++) {
        		sb.append(tmp[i]);
        	}
        	
            int n = Integer.parseInt(sb.toString());
            
            for(int i=2; i<n; i++) {
            	if(n%i == 0) return;
            }
            
            if(!hs.contains(n) && n > 1){
                hs.add(n);
                ans++;
            }
            return;
        }
        
        for(int i=0; i<N; i++){
        	if(!use[i]) {
        		use[i] = true;
        		tmp[idx] = numbers.charAt(i);
        		dfs(idx+1, numbers);
        		use[i] = false;
        	}
        }
    }
}