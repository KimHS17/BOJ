import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        int answer = 0;
        
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }
        
        if (N == number)
            return 1;
 
        dp.get(1).add(N);
        for (int i = 2; i <= 8; i++) {
            String n = Integer.toString(N);
            dp.get(i).add(Integer.parseInt(n.repeat(i)));

            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
 
            if (dp.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}