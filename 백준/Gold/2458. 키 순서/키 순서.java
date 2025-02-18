import java.io.*;
import java.util.*;

public class Main {
	static int find(List<Integer>[] height, int s, int n) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		int cnt = 0;
		
		q.add(s);
		visited[s] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next: height[now]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<Integer>[] small = new ArrayList[n + 1];
		List<Integer>[] tall = new ArrayList[n + 1];
		for(int i = 0; i <= n; i++) {
			small[i] = new ArrayList<>();
			tall[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			small[a].add(b);
			tall[b].add(a);
		}
		
		int cnt = 0, sum = 0;
		for(int i = 1; i <= n; i++) {
			sum = 0;
			sum += find(small, i, n);
			sum += find(tall, i, n);
			
			if(sum == n - 1) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
