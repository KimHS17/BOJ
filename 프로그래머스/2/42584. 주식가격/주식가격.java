import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> s = new Stack<>();
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            while(!s.isEmpty() && prices[s.peek()] > prices[i]) {
                answer[s.peek()] = i - s.peek();
                s.pop();
            }    
            s.push(i);
        }
        
        while(!s.isEmpty()) {
            answer[s.peek()] = prices.length - s.peek() - 1;
            s.pop();
        }
        
        return answer;
    }
}