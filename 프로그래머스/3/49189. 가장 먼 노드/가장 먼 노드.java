import java.util.*;

class Solution {
    public boolean[][] node;
    public boolean[] v;
    
    public int bfs(int n) {
        Queue<int[]> q = new LinkedList<>();
        int ans = 0, cnt = 0;
        
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            for(int i = 1; i < n; i++) {
                if(node[now[0]][i] && !v[i]) {
                    q.add(new int[]{i, now[1] + 1});
                    v[i] = true;
                    cnt++;
                }
            }
            if(!q.isEmpty() && q.peek()[1] != now[1]) {
                ans = cnt;
                cnt = 0;
            }
        }
        
        return ans;
    }
    
    public int solution(int n, int[][] edge) {
        node = new boolean[n][n];
        v = new boolean[n];
        int answer = 0;
        
        for(int[] e: edge) {
            node[e[0] - 1][e[1] - 1] = true;
            node[e[1] - 1][e[0] - 1] = true;
        }
        
        answer = bfs(n);
        
        return answer;
    }
}