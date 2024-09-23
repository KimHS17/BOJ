class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String target = Long.toBinaryString(numbers[i]);
                String tmp;
                int id = target.lastIndexOf("0");
                
                if (id == -1) {
                    tmp = "10" + target.substring(1, target.length());
                } else {
                    tmp = target.substring(0, id) + "10" + target.substring(id + 2, target.length());
                }
                answer[i] = Long.parseLong(tmp, 2);
            }
        }
        
        return answer;
    }
}