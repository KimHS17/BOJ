import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0, maxCop = 0;
        int[][] dp;
        int answer = 0;
        
        for(int[] problem: problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        
        dp = new int[maxAlp + 1][maxCop + 1];
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        for(int[] t: dp) {
            Arrays.fill(t, Integer.MAX_VALUE);
        }
        dp[alp][cop] = 0;
        
        for(int i = alp; i <= maxAlp; i++) {
            for(int j = cop; j <= maxCop; j++) {
                if(i + 1 <= maxAlp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                
                if(j + 1 <= maxCop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
                
                for (int[] problem: problems) {
                    if(problem[0] <= i && problem[1] <= j) {
                        int nextAlp = Math.min(maxAlp, i + problem[2]);
                        int nextCop = Math.min(maxCop, j + problem[3]);
                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        
        answer = dp[maxAlp][maxCop];
        
        return answer;
    }
}