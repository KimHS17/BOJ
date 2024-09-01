import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        ArrayList<Integer> camera = new ArrayList<>();
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        camera.add(routes[0][1]);
        
        for(int i = 1; i < routes.length; i++) {
            boolean flag = false;
            
            for(int c: camera) {
                if(routes[i][0] <= c && routes[i][1] >= c) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                answer++;
                camera.add(routes[i][1]);
            }
        }
        
        return answer;
    }
}