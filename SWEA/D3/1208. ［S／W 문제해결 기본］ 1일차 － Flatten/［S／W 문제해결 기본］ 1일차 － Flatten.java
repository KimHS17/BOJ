import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			PriorityQueue<Integer> min = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			int dump = sc.nextInt();
			for(int i = 0; i < 100; i++) {
				int t = sc.nextInt();
				min.add(t);
				max.add(t);
			}
			
			while(dump > 0) {
				min.add(min.poll() + 1);
				max.add(max.poll() - 1);
                dump--;
			}
			
			int res = max.poll() - min.poll();
			System.out.println("#" + test_case + " " + res);
		}
	}
}