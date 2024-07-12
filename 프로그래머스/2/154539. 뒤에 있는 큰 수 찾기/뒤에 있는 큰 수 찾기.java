import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> num = new Stack<>();
        
        num.push(0);
        for(int i = 1; i < numbers.length; i++) {
            while(!num.empty() && numbers[num.peek()] < numbers[i]) {
                answer[num.pop()] = numbers[i];
            }
            num.push(i);
        }
        
        while(!num.empty()) {
            answer[num.pop()] = -1;
        }
        
        return answer;
    }
}