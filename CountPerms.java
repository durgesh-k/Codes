import java.io.*;
import java.util.*;

class Solution {
	public static int countPerms(int n)
	{
		int mod = (int)(1e9 + 7);
		int[][] combinations = new int[][] {
			{ 1 }, { 0, 2 },
			{ 0, 1, 3, 4 },
			{ 2, 4 }, { 0 }
		};
		long[][] dp = new long[n + 1][5];
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 5; j++) {
				dp[i + 1][j] = 0;
				for (int k : combinations[j]) {
					dp[i + 1][j] += dp[i][k] % mod;
				}
			}
		}
		long ans = 0;

		for (int i = 0; i < 5; i++) {
			ans = (ans + dp[n][i]) % mod;
		}

		return (int)ans;
	}

	public static void main(String[] args)
	{
		System.out.println(countPerms(1));
		System.out.println(countPerms(2));
		System.out.println(countPerms(3));
	}
}
