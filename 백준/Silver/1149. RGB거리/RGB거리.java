import java.util.Scanner;

public class Main {	
	static int[][] arry = new int[1010][3];
	static int[][] dp = new int[1010][3];	
	static int N;
	
	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j < 3; j++) {
				arry[i][j] = scan.nextInt();
			}
		}
		
		int ret = dp();
		
		System.out.println(ret);

		scan.close();
	}
	
	private static int min(int a, int b) {
		return a>b?b:a;
	}

	private static int dp() {
		dp[1][0] = arry[1][0];
		dp[1][1] = arry[1][1];
		dp[1][2] = arry[1][2];
		
		for(int i = 1; i <= N; i++) {
			dp[i][0] = arry[i][0] + min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = arry[i][1] + min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = arry[i][2] + min(dp[i-1][0], dp[i-1][1]);
		}
		
		return min(min(dp[N][0], dp[N][1]), dp[N][2]);
	}

}