import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int n;

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] arr = new int[n > 2 ? n : 2][3];
		int[] dp = new int[n > 2 ? n : 2];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
				if(i == 0)
					dp[0] = arr[0][2];
				else if(i == 1)
					dp[1] = arr[0][2] > arr[1][2] ? arr[0][2] : arr[1][2];
				else {
					dp[i] = dp[i - 1] > dp[i - 2] + arr[i][2] ? dp[i - 1] : dp[i - 2] + arr[i][2];
				}
			}
		}

		System.out.println(dp[n - 1]);
	}
}
