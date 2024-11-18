import java.util.*;

class Solution {
    static int n = 2500;
    static int[] group = new int[n];
    static String[] value = new String[n];
    
    static int find(int idx) {
        if(idx == group[idx])
            return idx;
        
        return group[idx] = find(group[idx]);
    }
    
    static void union(int g1, int g2) {
        g1 = find(g1);
        g2 = find(g2);
        
        if(g1 == g2)
            return;
        
        value[g2] = null;
        group[g2] = g1;
    }
    
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            group[i] = i;
        }
        
        for(String command: commands) {
            String[] com = command.split(" ");
            
            if(com[0].equals("UPDATE")) {
                if(com.length == 4) {
                    int r = Integer.parseInt(com[1]) - 1;
                    int c = Integer.parseInt(com[2]) - 1;

                    value[find(r * 50 + c)] = com[3];
                } else {
                    for(int i = 0; i < n; i++) {
                        int idx = find(i);
                        
                        if(value[idx] != null && value[idx].equals(com[1])) {
                            value[idx] = com[2];
                        }
                    }
                }
            } else if(com[0].equals("MERGE")) {
                int r1 = Integer.parseInt(com[1]) - 1;
                int c1 = Integer.parseInt(com[2]) - 1;
                int r2 = Integer.parseInt(com[3]) - 1;
                int c2 = Integer.parseInt(com[4]) - 1;
                int idx1 = r1 * 50 + c1;
                int idx2 = r2 * 50 + c2;
                
                if(value[find(idx1)] == null && value[find(idx2)] != null) {
                    int tmp = idx1;
                    idx1 = idx2;
                    idx2 = tmp;
                }
                
                union(idx1, idx2);
            } else if(com[0].equals("UNMERGE")) {
                int r = Integer.parseInt(com[1]) - 1;
                int c = Integer.parseInt(com[2]) - 1;
                int idx = r * 50 + c;
                int g = find(idx);
                String v = value[g];
                
                for(int i = 0; i < n; i++) {
                    find(i);
                }
                
                for(int i = 0; i < n; i++) {
                    if(find(i) == g) {
                        group[i] = i;
                        value[i] = i == idx ? v : null;
                    }
                }
            } else if(com[0].equals("PRINT")) {
                int r = Integer.parseInt(com[1]) - 1;
                int c = Integer.parseInt(com[2]) - 1;
                int idx = r * 50 + c;
                String v = value[find(idx)];
                
                answer.add(v == null ? "EMPTY" : v);
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}