import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, LocalTime> map = new HashMap<>();
        HashMap<String, Long> time = new HashMap<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        ArrayList<Integer> answer = new ArrayList<>();

        for(String r: records) {
            String[] t = r.split(" ");
            if(t[2].equals("IN")) {
                map.put(t[1], LocalTime.parse(t[0], format));
            } else {
                Long m = ChronoUnit.MINUTES.between(map.get(t[1]), LocalTime.parse(t[0], format));
                time.put(t[1], time.getOrDefault(t[1], 0L) + m);
                map.remove(t[1]);
            }
        }
        
        for (Map.Entry<String, LocalTime> entry : map.entrySet()) {
            Long m = ChronoUnit.MINUTES.between(entry.getValue(), LocalTime.of(23, 59));
            time.put(entry.getKey(), time.getOrDefault(entry.getKey(), 0L) + m);
        }
        
        List<String> keySet = new ArrayList<>(time.keySet());
        keySet.sort((o1, o2) -> o1.compareTo(o2));
        for(String key: keySet) {
            Long m = time.get(key);
            int fee = fees[1];
            m -= fees[0];
            if(m > 0) {
                fee += m / fees[2] * fees[3];
                if(m % fees[2] > 0)
                    fee += fees[3];
            }
            answer.add(fee);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}