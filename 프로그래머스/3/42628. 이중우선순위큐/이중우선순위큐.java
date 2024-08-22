import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> qa= new PriorityQueue<>();
        PriorityQueue<Integer> qd = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = {};
        
        for(int i = 0; i < operations.length; i++) {
            if(operations[i].charAt(0) == 'I') {
                String n = operations[i].substring(2, operations[i].length());
                qa.add(Integer.parseInt(n));
                qd.add(Integer.parseInt(n));
            }
            else if(qa.isEmpty()) {
                continue;
            }
            else if(operations[i].charAt(2) == '1') {
                int num = qd.poll();
                qa.remove(num);
            }
            else {
                int num = qa.poll();
                qd.remove(num);
            }
        }
        
        if(qa.isEmpty()) {
            answer = new int[]{0, 0};
        }
        else {
            answer = new int[]{qd.peek(), qa.peek()};
        }
        
        return answer;
    }
}