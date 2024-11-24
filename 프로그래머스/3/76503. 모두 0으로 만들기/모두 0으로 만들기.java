import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static long[] sum;
    static boolean[] visited;
    static long cnt = 0;
    
    static long dfs(int idx) {
        visited[idx] = true;
        
        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            
            if(!visited[next])
                sum[idx] += dfs(next);
        }
        
        cnt += Math.abs(sum[idx]);
        
        return sum[idx];
    }
    
    public long solution(int[] a, int[][] edges) {
        int len = a.length;
        graph = new ArrayList[len];
        sum = new long[len];
        visited = new boolean[len];
        long answer = -1;
        
        for(int i = 0; i < len; i++) {
            graph[i] = new ArrayList<Integer>();
            sum[i] = a[i];
        }
        
        for(int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        if(dfs(0) == 0)
            answer = cnt;
        
        return answer;
    }
}