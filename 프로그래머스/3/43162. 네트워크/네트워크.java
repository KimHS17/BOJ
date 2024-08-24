import java.util.*;

class Solution {
    static int ans = 0;
    
    public static void bfs(int [][] computers, int n, int i) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(i);
        computers[i][i] = 0;
        ans++;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int k = 0; k < n; k++) {
                if(computers[now][k] == 1 && computers[k][k] != 0) {
                    q.add(k);
                }
                computers[now][k] = 0;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    bfs(computers, n, i);
                }
            }
        }
        
        return ans;
    }
}