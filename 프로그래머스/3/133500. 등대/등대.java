import java.util.*;

class Solution {
    static List<Integer> graph[];
    static boolean[] visited;
    static int answer = 0;
    
    public int dfs(int idx) {
        int tmp = 0;
        
        visited[idx] = true;
        
        for(int cur: graph[idx]) {
            if(!visited[cur]) {
                tmp += dfs(cur);
            }
        }
        
        if(tmp == 0)
            return 1;
        
        answer++;
        
        return 0;
    }
    
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] lh: lighthouse) {
            graph[lh[0]].add(lh[1]);
            graph[lh[1]].add(lh[0]);
        }
        
        dfs(1);
        
        return answer;
    }
}