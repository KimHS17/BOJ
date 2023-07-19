import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] m = new int[100001];

    public static void bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0, sec = Integer.MAX_VALUE;

        q.add(n);

        while(!q.isEmpty()) {
            int now = q.peek();
            q.remove();
            int a = now - 1;
            int b = now + 1;
            int c = now * 2;
            
            if((a == k || b == k || c == k) && m[now] + 1 <= sec) {
                sec = m[now] + 1;
                cnt++;
            }

            if(a >= 0 && (m[a] == 0 || m[a] == m[now] + 1)) {
                m[a] = m[now] + 1;
                q.add(a);
            }
            if(b <= 100000 && (m[b] == 0 || m[b] == m[now] + 1)) {
                m[b] = m[now] + 1;
                q.add(b);
            }
            if(c >= 0 && c <= 100000 && (m[c] == 0 || m[c] == m[now] + 1)) {
                m[c] = m[now] + 1;
                q.add(c);
            }
        }
        System.out.println(sec);
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        int n, k;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        
        if(n == k) {
            System.out.println(0); 
            System.out.println(1);
        }
        else
            bfs(n, k);
    }
}