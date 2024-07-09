import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    private LocalTime time(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(str, formatter);
    }
    
    public int solution(String[][] book_time) {
        ArrayList<String> room = new ArrayList();

        Arrays.sort(book_time, (a, b) -> {
            return time(a[0]).compareTo(time(b[0]));
        });
        
        room.add(book_time[0][1]);
        for(int i = 1; i < book_time.length; i++) {
            boolean isAfter = false;
            
            for(int j = 0; j < room.size(); j++) {
                LocalTime endTime = time(room.get(j));
                
                if(endTime.isAfter(time("23:49"))) {
                    isAfter = true;
                    continue;
                }
                else {
                    endTime = endTime.plusMinutes(10);
                }
                
                if(endTime.isAfter(time(book_time[i][0]))) {
                    isAfter = true;
                }
                else {
                    isAfter = false;
                    room.set(j, book_time[i][1]);
                    break;
                }
            }
            if(isAfter) {
                room.add(book_time[i][1]);
            }
        }
        
        return room.size();
    }
}