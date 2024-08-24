import java.util.*;

class Solution {
    public static void bfs(int [][] computers, int n, int i) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(i);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int k = 0; k < n; k++) {
                if(computers[now][k] == 1 && computers[k][k] != 0 && now != k) {
                    q.add(k);
                }
                computers[now][k] = 0;
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(computers[i][i] == 1) {
                bfs(computers, n, i);
                answer++;
            }
        }
        
        return answer;
    }
}