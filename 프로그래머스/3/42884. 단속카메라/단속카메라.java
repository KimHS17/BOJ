import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int c;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        c = routes[0][1];
        
        for(int i = 1; i < routes.length; i++) {
            if(routes[i][0] > c) {
                answer++;
                c = routes[i][1];
            }
        }
        
        return answer;
    }
}