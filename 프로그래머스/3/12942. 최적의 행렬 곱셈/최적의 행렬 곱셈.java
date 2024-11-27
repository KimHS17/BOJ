import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int len = matrix_sizes.length;
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                int a = j, b = i + j;
                
                if(a == b) {
                    dp[a][b] = 0;
                } else {
                    for(int k = a; k < b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b] + matrix_sizes[a][0] * matrix_sizes[k][1] * matrix_sizes[b][1]);
                    }
                }
            }
        }
        answer = dp[0][len - 1];
        
        return answer;
    }
}