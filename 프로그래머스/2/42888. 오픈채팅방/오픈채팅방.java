import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> user = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();
    
        for(String r: record) {
            String[] t = r.split(" ");
            
            if(t.length == 3) {
                user.put(t[1], t[2]);
            }
        }
        
        for(String r: record) {
            String[] t = r.split(" ");
            
            if(t[0].equals("Enter")) {
                answer.add(user.get(t[1]) + "님이 들어왔습니다.");
            } else if(t[0].equals("Leave")) {
                answer.add(user.get(t[1]) + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}