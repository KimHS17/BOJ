import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    private LocalTime time(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(str, formatter);
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        LocalTime s = time("09:00");
        int cntN = 0, cntM = 0, i = 0;

        Arrays.sort(timetable, (a, b) -> {
            return time(a).compareTo(time(b));
        });
        
        while(i < timetable.length) {
            if(!time(timetable[i]).isAfter(s)) {
                cntM++;
                i++;
            } else {
                cntN++;
                if(cntN < n) {
                    cntM = 0;
                }
                s = s.plusMinutes(t);
            }
            if(cntM == m) {
                cntN++;
                if(cntN < n) {
                    cntM = 0;
                }
                s = s.plusMinutes(t);
            }
            
            if(cntN == n || i == timetable.length) {
                if(cntM == m) {
                    answer = time(timetable[i - 1]).minusMinutes(1).toString();
                } else {
                    if(cntM < m && cntN > 0) {
                        if(cntN < n) {
                            answer = s.plusMinutes((n - cntN - 1) * t).toString();
                        } else {
                            answer = s.minusMinutes(t).toString();
                        }
                    } else {
                        answer = s.toString();
                    }
                }
                break;
            }
        }
        
        return answer;
    }
}