import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] cnt = new int[n + 1][m + 1];

        for(int[] w: puddles) {
            cnt[w[1]][w[0]] = -1;
        }
        
        cnt[1][0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(cnt[i][j] != -1) {
                    int c = 0;
                    
                    if(cnt[i - 1][j] == -1)
                        c++;
                    if(cnt[i][j - 1] == -1)
                        c++;
                    
                    cnt[i][j] = (cnt[i - 1][j] + cnt[i][j - 1] + c) % 1000000007;
                }
            }
        }
        
        return cnt[n][m];
    }
}