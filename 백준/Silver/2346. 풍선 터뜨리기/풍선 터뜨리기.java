import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        int n = sc.nextInt();
        int[] balloon = new int[n];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            balloon[i] = sc.nextInt();
            dq.add(i + 1);
        }

        while (true) {
            int now = dq.poll();
            int num = balloon[now - 1];

            sb.append(now + " ");
            
            if(dq.isEmpty()) {
                break;
            }

            if(num > 0) {
                for(int i = 1; i < num; i++) {
                    dq.add(dq.poll());
                }
            } else {
                for(int i = num; i < 0; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
        sc.close();
    }
}