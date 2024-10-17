import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] wh = scores[0];
        int max = 0;
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        for(int[] score: scores) {
            if(max <= score[1]) {
                max = score[1];
                if(score[0] + score[1] > wh[0] + wh[1]) {
                    answer++;
                }
            } else if(score.equals(wh)) {
                return -1;
            }
        }
        
        return answer;
    }
}