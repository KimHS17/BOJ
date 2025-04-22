import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static long[] num;

    public static long init(int start, int end, int node) {
        if(start == end)
            return tree[node] = num[start];
        
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start)
            return 0;

        if(left <= start && end <= right)
            return tree[node];
        
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int idx, long dif) {
        if(idx < start || end < idx)
            return;

        tree[node] += dif;

        if(start == end)
            return;
        
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        tree = new long[n * 4];
        num = new long[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if(a == 1) {
                update(1, n, 1, b, c - num[b]);
                num[b] = c;
            } else if(a == 2) {
                System.out.println(sum(1, n, 1, b, (int) c));
            }
        }
    }
}
