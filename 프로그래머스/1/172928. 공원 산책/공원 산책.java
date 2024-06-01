import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        HashMap<Character, List<Integer>> dir = new HashMap<Character, List<Integer>>();
        int[] answer = new int[2];
        
        dir.put('N', List.of(-1, 0));
        dir.put('S', List.of(1, 0));
        dir.put('W', List.of(0, -1));
        dir.put('E', List.of(0, 1));
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                if(park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;   
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            boolean move = true;
            int y = answer[0], x = answer[1];
            for(int j = 1; j <= routes[i].charAt(2) - '0'; j++) {
                int ny = answer[0] + dir.get(routes[i].charAt(0)).get(0) * j;
                int nx = answer[1] + dir.get(routes[i].charAt(0)).get(1) * j;

                if(nx < 0 || nx >= park[0].length() || ny < 0 || ny >= park.length || park[ny].charAt(nx) == 'X')
                    move = false;
                y = ny;
                x = nx;
            }
            if(move) {
                answer[0] = y;
                answer[1] = x;
            }
        }
        
        return answer;
    }
}