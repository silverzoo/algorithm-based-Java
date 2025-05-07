import java.util.Scanner;
 
public class Main {
	
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		arr = new int[n];
		dp = new Integer[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = arr[0];
        max = arr[0];
		
		recur(n - 1);
		
		System.out.println(max);
	}
	
	static int recur(int n) {
		
		// 탐색하지 않은 인덱스는 max와 비교
		if(dp[n] == null) {
			dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
 
			max = Math.max(dp[n], max);
		}
		
		return dp[n];
	}
}