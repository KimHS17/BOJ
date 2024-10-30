import java.util.*;

class Solution {
    public int toSec(String time) {
        int sec = 0;
        String[] t = time.split(":");
        
        sec += Integer.parseInt(t[0]) * 3600;
        sec += Integer.parseInt(t[1]) * 60;
        sec += Integer.parseInt(t[2]);
        
        return sec;
    }
    
    public String toTime(int sec) {
        String time = "";
        
        time += (sec / 3600 < 10 ? "0" : "") + sec / 3600 + ":";
        sec %= 3600;
        
        time += (sec / 60 < 10 ? "0" : "") + sec / 60 + ":";
        sec %= 60;
        
        time += (sec < 10 ? "0" : "") + sec;
        
        return time;
    }
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int len = toSec(play_time);
        long[] time = new long[len + 1];
        int adv = toSec(adv_time);
        int maxIdx = 0;
        long maxTime;
        String answer = "";
        
        for(String log: logs) {
            String[] t = log.split("-");
            int start = toSec(t[0]);
            int end = toSec(t[1]);
            
            time[start] += 1;
            time[end] -= 1;
        }
        
        for(int i = 1; i <= len; i++) {
            time[i] += time[i - 1];
        }
        
        for(int i = 1; i <= len; i++) {
            time[i] += time[i - 1];
        }
        
        maxTime = time[adv - 1];
        for(int i = adv; i <= len; i++) {
            long totalTime = time[i] - time[i - adv];
            
            if(maxTime < totalTime) {
                maxTime = totalTime;
                maxIdx = i - adv + 1;
            }
        }
        
        answer = toTime(maxIdx);
        
        return answer;
    }
}