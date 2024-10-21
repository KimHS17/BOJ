import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static boolean[] check;
    
    static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
	}
    
    static void dfs(String str, String temp, int m) {
        if(temp.length() == m) {
            int num = Integer.parseInt(temp);
            
            if(!set.contains(num)) {
                set.add(num);
            }
        }

        for(int i=0; i<str.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(str, temp + str.charAt(i), m);
                check[i] = false;
            }
        }
	}
    
    public int solution(String numbers) {
        int answer = 0;
        check = new boolean[numbers.length()];
        
        for(int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1);
        }
        
        for(int num: set) {
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
}