import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int answer = 0, id = 0, cnt = 0, total = 0, end = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        while(cnt < jobs.length) {
            while(id < jobs.length && jobs[id][0] <= end) {
                pq.add(jobs[id++]);
            }
            
            if(pq.isEmpty()) {
                end = jobs[id][0];
            } else {
                int[] now = pq.poll();
                total += now[1] + end - now[0];
                end += now[1];
                cnt++;
            }
        }
        answer = total / jobs.length;
        
        return answer;
    }
}