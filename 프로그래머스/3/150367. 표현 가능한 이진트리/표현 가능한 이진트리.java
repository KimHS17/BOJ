import java.util.*;

class Solution {
    static boolean check(String number) {
        int len = number.length();
        
        if(len < 3)
            return true;
        
        int mid = len / 2;
        char root = number.charAt(mid);
        String left = number.substring(0, mid);
        String right = number.substring(mid + 1, len);
        char leftNode = left.charAt(left.length() / 2);
        char rightNode = right.charAt(right.length() / 2);
        
        if(root == '0' && (leftNode == '1' || rightNode == '1'))
            return false;

        if(!check(left) || !check(right))
            return false;
        
        return true;
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            String number = Long.toBinaryString(numbers[i]);
            int height = 0, cnt = 0;
            
            while(cnt < number.length()) {
                cnt = (int)Math.pow(2, ++height) - 1;
            }
            
            number = "0".repeat(cnt - number.length()) + number;
            
            if(check(number)) {
                answer[i] = 1;
            }
        }
        
        return answer;
    }
}