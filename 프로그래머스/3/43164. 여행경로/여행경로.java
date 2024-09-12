import java.util.*;

public class Solution {
    public static boolean[] v;
    public static String result;
    public static boolean check = false;

    public static void dfs(int id, String s, String r, String[][] tickets) {        
        if (id == tickets.length) {
            result = r;
            check = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(check)
                break;
            
            if (tickets[i][0].equals(s) && !v[i]) {
                v[i] = true;
                dfs(id + 1, tickets[i][1], r + " " + tickets[i][1], tickets);
                v[i] = false;
            }
        }
        
        return;
    }
    
    public static String[] solution(String[][] tickets) {
        v = new boolean[tickets.length];
        
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });
        
        dfs(0, "ICN", "ICN", tickets);
        String[] answer = result.split(" ");
        
        return answer;
    }
}