import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int[commands.length];
        int ansIdx = 0;
        
        for(int[] cmd : commands){
            int copy[] = Arrays.copyOfRange(array, cmd[0]-1, cmd[1]);
            Arrays.sort(copy);
            answer[ansIdx++] = copy[cmd[2]-1];
        }
        return answer;
    }
}