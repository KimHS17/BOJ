import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for(int i = 1; i < land.length; i++) {
            for(int j = 0; j < 4; j++) {
                int[] t = land[i - 1].clone();
                t[j] = 0;
                Arrays.sort(t);
                land[i][j] += t[3];
            }
        }
        
        Arrays.sort(land[land.length - 1]);
        answer = land[land.length - 1][3];
        
        return answer;
    }
}