import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int i = 0; i < s.length; i++) {
            int cnt = 0, z = -1, len;
            StringBuilder str = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j < s[i].length(); j++) {
                str.append(s[i].charAt(j));
                len = str.length();
                
                if(len > 2) {
                    if(str.substring(len - 3).equals("110")) {
                        str.delete(len - 3, len);
                        sb.append("110");
                        len = str.length();
                    }
                }
                if(len > 0 && str.charAt(len - 1) == '0') {
                    z = len - 1;
                }
            }

            answer[i] = str.substring(0, z + 1) + sb + str.substring(z + 1);
        }
        
        return answer;
    }
}