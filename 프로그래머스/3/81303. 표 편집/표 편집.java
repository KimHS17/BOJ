import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        int now = k, size = n;

        for(String c: cmd) {
            switch(c.charAt(0)) {
                case 'U':
                    now -= Integer.parseInt(c.substring(2));
                    break;
                case 'D':
                    now += Integer.parseInt(c.substring(2));
                    break;
                case 'C':
                    deleted.push(now);
                    size--;
                    if(now == size)
                        now--;
                    break;
                case 'Z':
                    int d = deleted.pop();
                    size++;
                    if(now >= d)
                        now++;
                    break;
            }
        }
        
        StringBuilder ans = new StringBuilder("O".repeat(size));
        while(!deleted.isEmpty()) {
            int d = deleted.pop();
            ans.insert(d, "X");
        }
        
        return ans.toString();
    }
}