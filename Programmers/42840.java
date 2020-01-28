import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int p1[] = {1,2,3,4,5};
        int p2[] = {2,1,2,3,2,4,2,5};
        int p3[] = {3,3,1,1,2,2,4,4,5,5};
        int answer[] = {0, 0, 0};
        
        for(int i=0; i<answers.length; i++){
            if(p1[i%p1.length] == answers[i]) answer[0]++; 
            if(p2[i%p2.length] == answers[i]) answer[1]++; 
            if(p3[i%p3.length] == answers[i]) answer[2]++;
        }
        
        int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> maxList = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(max == answer[i]){
                maxList.add(i+1);
            }
        }
        
        int result[] = new int[maxList.size()];
        for(int i=0; i<maxList.size(); i++){
            result[i] = maxList.get(i);
        }
        
        return result;
    }
}