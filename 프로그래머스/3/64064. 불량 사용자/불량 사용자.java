import java.util.*;

class Solution {
    static boolean[] check;
    static HashSet<String> set;
    
    public void find(int cnt, String res, String[] user_id, String[] banned_id) {
        if(cnt == banned_id.length) {
            String str = "";
            String[] arr = res.split(" ");
            
            Arrays.sort(arr);
            for(String s: arr) {
                str += s;
            }
            set.add(str);
            
            return;
        }
        
        for(int i = 0; i < user_id.length; i++) {
            if(check[i] || !user_id[i].matches(banned_id[cnt]))
                continue;
            
            check[i] = true;
            find(cnt + 1, user_id[i] + " " + res, user_id, banned_id);
            check[i] = false;
        }
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        set = new HashSet<String>();

        for(int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        
        find(0, "", user_id, banned_id);
        
        return set.size();
    }
}