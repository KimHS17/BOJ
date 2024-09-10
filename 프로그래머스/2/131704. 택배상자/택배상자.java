import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0, n = 0, id = 0;
        
        while(id < order.length) {
            if(!stack.isEmpty() && stack.peek().intValue() == order[id]) {
                stack.pop();
                answer++;
                id++;
            } else if(order[id] == n + 1) {
                answer++;
                id++;
                n++;
            } else if(n >= order.length) {
                break;
            } else {
                stack.push(n + 1);
                n++;
            }
        }
        
        return answer;
    }
}