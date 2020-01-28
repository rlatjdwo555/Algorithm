class Solution {
    
    static int N = 10, M = 3;
	static int tmp[] = new int[3];
	static boolean use[] = new boolean[10];
	static int ans = 0;
    
    public int solution(int[][] baseball) {
        dfs(0, baseball);
    	return ans;
    }
    
    static void dfs(int idx, int[][] baseball) {
    	if(idx == M) {   		
    		for(int i=0; i<baseball.length; i++) {
    			char num[] = String.valueOf(baseball[i][0]).toCharArray();    	   			
        		int strike = 0;
        		int ball = 0;
    			
    			for(int j=0; j<3; j++) {
    				for(int k=0; k<3; k++) {
    					if(tmp[j] == num[k]-'0' && j == k) {
    						strike++;
    					}
    					else if(tmp[j] == num[k]-'0') {
    						ball++;
    					}
    				}
    			}
    			
    			if(baseball[i][1] != strike || baseball[i][2] != ball) {
    				return;
    			}
    			
    		}
    		ans++;
    		return;
    	}
    	
    	for(int i=1; i<10; i++) {
    		if(!use[i]) {
    			use[i] = true;
    			tmp[idx] = i;
    			dfs(idx+1, baseball);
    			use[i] = false;
    		}
    	}
    }
}