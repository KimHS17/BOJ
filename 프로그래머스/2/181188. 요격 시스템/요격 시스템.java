import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        int end;
        
        Arrays.sort(targets, (a, b) -> { return a[1] - b[1]; });
        end = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(targets[i][0] >= end) {
                end = targets[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}