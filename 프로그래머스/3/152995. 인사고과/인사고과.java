import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] s1 = new int[2];
        int[] s2 = new int[2];
        ArrayList<Integer> rank = new ArrayList<>();
        
        for(int[] score: scores) {
            if(score[0] > s1[0] || (score[0] == s1[0] && score[1] > s1[1])) {
                s1[0] = score[0];
                s1[1] = score[1];
            }
            if(score[1] > s2[1] || (score[1] == s2[1] && score[0] > s2[0])) {
                s2[0] = score[0];
                s2[1] = score[1];
            }
        }
        
        for(int i = 0; i < scores.length; i++) {
            if((scores[i][0] < s1[0] && scores[i][1] < s1[1]) || (scores[i][0] < s2[0] && scores[i][1] < s2[1])) {
                if(i == 0) {
                    return -1;
                }
            } else if(scores[0][0] + scores[0][1] < scores[i][0] + scores[i][1]) {
                answer++;
            }
        }
        
        return answer;
    }
}