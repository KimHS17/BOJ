import java.util.*;

class Solution {
    public int gcdAll(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    
    public int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1%num2);
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int a, b;
        boolean divA = false, divB = false;
        
        a = gcdAll(arrayA);
        b = gcdAll(arrayB);

        for(int num : arrayA) {
            if(num % b == 0) {
                divA = true;
                break;
            }
        }
        for(int num : arrayB) {
            if(num % a == 0) {
                divB = true;
                break;
            }
        }
        
        if(divA && divB) {
            answer = 0;
        }
        else if(divA) {
            answer = a;
        }
        else if(divB) {
            answer = b;
        }
        else {
            answer = a > b ? a : b;
        }
        
        return answer;
    }
}