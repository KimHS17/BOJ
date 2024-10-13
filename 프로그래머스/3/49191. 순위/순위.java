import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int[][] g = new int[n + 1][n + 1];
        int answer = 0;
        
        for(int i = 0; i < results.length; i++) {
            g[results[i][0]][results[i][1]] = 1; 
            g[results[i][1]][results[i][0]] = -1; 
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(g[i][k] == 1 && g[k][j] == 1) {
                        g[i][j] = 1;
                        g[j][i] = -1;
                    }
                    if(g[i][k] == -1 && g[k][j] == -1) {
                        g[i][j] = -1;
                        g[j][i] = 1;
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            
            for(int j = 1; j <= n; j++){
                if(g[i][j] != 0) cnt++;
            }
            if(cnt == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}