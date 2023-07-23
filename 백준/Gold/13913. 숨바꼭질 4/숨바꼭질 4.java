import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] m = new int[100001];
    static String[] r = new String[100001];

    public static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        q.add(n);

        while(!q.isEmpty()) {
            int now = q.peek();
            q.remove();
            int a = now - 1;
            int b = now + 1;
            int c = now * 2;
            
            if(a == k || b == k || c == k) {
                r[k] = r[now] + " " + k;
                r[now] = null;
                return ++m[now];
            }

            if(a >= 0 && m[a] == 0) {
                m[a] = m[now] + 1;
                q.add(a);
                r[a] = r[now] + " " + a;
            }
            if(b <= 100000 && m[b] == 0) {
                m[b] = m[now] + 1;
                q.add(b);
                r[b] = r[now] + " " + b;
            }
            if(c >= 0 && c <= 100000 && m[c] == 0) {
                m[c] = m[now] + 1;
                q.add(c);
                r[c] = r[now] + " " + c;
            }
            r[now] = null;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n, k;

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        r[n] = Integer.toString(n);
        
        if(n == k) {
            System.out.println(0);
            System.out.println(n);
        }
        else if(n < k){
            System.out.println(bfs(n, k));
            System.out.println(r[k]);
        }
        else {
            System.out.println(n - k);
            while(n >= k)
                System.out.print(n-- + " ");
        }
        sc.close();
    }
}