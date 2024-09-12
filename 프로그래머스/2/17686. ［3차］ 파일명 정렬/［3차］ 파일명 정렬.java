import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[][] f = new String[files.length][3];
        String[] answer = new String[files.length];
        
        for(int i = 0; i < files.length; i++) {
            int id = 0;
            
            for(int j = 0; j < files[i].length(); j++) {
                char t = files[i].charAt(j);
                if(id == 0 && Character.isDigit(t)) {
                    f[i][0] = files[i].substring(0, j);
                    id = j;
                } else if(id != 0 && !Character.isDigit(t)) {
                    f[i][1] = files[i].substring(id, j);
                    f[i][2] = files[i].substring(j, files[i].length());
                    break;
                }
            }
            if(f[i][1] == null) {
                f[i][1] = files[i].substring(id, files[i].length());
            }
        }

        Arrays.sort(f, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[0].toLowerCase().contentEquals(o2[0].toLowerCase())) {
                    return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                } else {
                    return o1[0].toLowerCase().compareTo(o2[0].toLowerCase());
                }
            }
        });
        
        for(int i = 0; i < f.length; i++) {
            answer[i] = f[i][0] + f[i][1];
            if(f[i][2] != null)
                answer[i] += f[i][2];
        }
        
        return answer;
    }
}